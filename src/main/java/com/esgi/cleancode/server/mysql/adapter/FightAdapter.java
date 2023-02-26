package com.esgi.cleancode.server.mysql.adapter;

import com.esgi.cleancode.domain.functional.model.Fight;
import com.esgi.cleancode.domain.functional.model.Hero;
import com.esgi.cleancode.domain.ports.ApplicationError;
import com.esgi.cleancode.domain.ports.server.FightDbPort;
import com.esgi.cleancode.server.mysql.dao.FightDao;
import com.esgi.cleancode.server.mysql.entity.FightEntity;
import com.esgi.cleancode.server.mysql.entity.HeroEntity;
import com.esgi.cleancode.server.mysql.mapper.FightEntityMapper;
import com.esgi.cleancode.server.mysql.mapper.HeroEntityMapper;
import io.vavr.control.Either;

import java.util.List;

import static com.esgi.cleancode.server.mysql.mapper.FightEntityMapper.fromDomain;
import static io.vavr.API.Try;

public class FightAdapter extends FightDao implements FightDbPort {


    @Override
    public Either<ApplicationError, Fight> save(Fight o) {
        FightEntity entity = fromDomain(o);
        return Try(() -> super.insert(entity))
                .toEither()
                .mapLeft(throwable -> new ApplicationError("Unable to save licence", null, o, throwable))
                .map(FightEntityMapper::toDomain);
    }

    @Override
    public Either<ApplicationError, List<Fight>> getAll() {
        return Try(() -> super.getList("SELECT * FROM fight;", FightEntity.class))
                .toEither()
                .mapLeft(throwable -> new ApplicationError("Unable to save licence", null, null, throwable))
                .map(FightEntityMapper::toDomainList);
    }

    @Override
    public Either<ApplicationError, Fight> getById(Integer id) {

        return Try(() -> super.get("SELECT * FROM hero_template WHERE id="+id + ";", FightEntity.class))
                .toEither()
                .mapLeft(throwable -> new ApplicationError("Unable to save licence", null, null, throwable))
                .map(FightEntityMapper::toDomain);
    }

    @Override
    public Either<ApplicationError, Fight> update(Fight o) {

            FightEntity entity = FightEntityMapper.fromDomain(o);

            return Try(() -> super.update(entity))
                    .toEither()
                    .mapLeft(throwable -> new ApplicationError("Unable to update fight", null, null, throwable))
                    .map(FightEntityMapper::toDomain);

    }

}
