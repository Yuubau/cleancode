package com.esgi.cleancode.server.mysql.adapter;

import com.esgi.cleancode.domain.functional.model.Hero;
import com.esgi.cleancode.domain.ports.ApplicationError;
import com.esgi.cleancode.domain.ports.server.HeroDbPort;
import com.esgi.cleancode.server.mysql.dao.HeroDao;
import com.esgi.cleancode.server.mysql.entity.HeroEntity;
import com.esgi.cleancode.server.mysql.mapper.HeroEntityMapper;
import io.vavr.control.Either;

import java.util.List;

import static com.esgi.cleancode.server.mysql.mapper.HeroEntityMapper.fromDomain;
import static io.vavr.API.Try;

public class HeroAdapter extends HeroDao implements HeroDbPort {


    @Override
    public Either<ApplicationError, Hero> save(Hero o) {
        HeroEntity entity = fromDomain(o);
        return Try(() -> super.insert(entity))
                .toEither()
                .mapLeft(throwable -> new ApplicationError("Unable to save licence", null, o, throwable))
                .map(HeroEntityMapper::toDomain);
    }

    @Override
    public Either<ApplicationError, List<Hero>> getAll() {
        return Try(() -> super.getList("SELECT * FROM hero ORDER BY NEWID();", HeroEntity.class))
                .toEither()
                .mapLeft(throwable -> new ApplicationError("Unable to save licence", null, null, throwable))
                .map(HeroEntityMapper::toDomainList);
    }

    @Override
    public Either<ApplicationError, Hero> getById(Integer id) {

        return Try(() -> super.get("SELECT * FROM hero WHERE id="+id + ";", HeroEntity.class))
                .toEither()
                .mapLeft(throwable -> new ApplicationError("Unable to save licence", null, null, throwable))
                .map(HeroEntityMapper::toDomain);
    }

    @Override
    public Either<ApplicationError, Hero> update(Hero o) {
        HeroEntity entity = fromDomain(o);

        return Try(() -> super.update(entity))
                .toEither()
                .mapLeft(throwable -> new ApplicationError("Unable to update Hero", null, null, throwable))
                .map(HeroEntityMapper::toDomain);
    }

    @Override
    public Either<ApplicationError, List<Hero>> getPlayerHero(Integer playerId) {
        return Try(() -> super.getList("SELECT * FROM hero where player_id =" + playerId + ";", HeroEntity.class))
                .toEither()
                .mapLeft(throwable -> new ApplicationError("Unable to fetch datas", null, null, throwable))
                .map(HeroEntityMapper::toDomainList);
    }

}
