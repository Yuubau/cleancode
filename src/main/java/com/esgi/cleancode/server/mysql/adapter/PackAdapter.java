package com.esgi.cleancode.server.mysql.adapter;

import com.esgi.cleancode.domain.functional.model.Hero;
import com.esgi.cleancode.domain.functional.model.Pack;
import com.esgi.cleancode.domain.functional.model.Player;
import com.esgi.cleancode.domain.ports.ApplicationError;
import com.esgi.cleancode.domain.ports.server.PackDbPort;
import com.esgi.cleancode.domain.ports.server.PlayerDbPort;
import com.esgi.cleancode.server.mysql.dao.PackDao;
import com.esgi.cleancode.server.mysql.dao.PlayerDao;
import com.esgi.cleancode.server.mysql.entity.HeroEntity;
import com.esgi.cleancode.server.mysql.entity.HeroTemplateEntity;
import com.esgi.cleancode.server.mysql.entity.PackEntity;
import com.esgi.cleancode.server.mysql.entity.PlayerEntity;
import com.esgi.cleancode.server.mysql.mapper.HeroEntityMapper;
import com.esgi.cleancode.server.mysql.mapper.HeroTemplateEntityMapper;
import com.esgi.cleancode.server.mysql.mapper.PackEntityMapper;
import io.vavr.control.Either;

import java.util.List;

import static com.esgi.cleancode.server.mysql.mapper.PackEntityMapper.fromDomain;
import static io.vavr.API.Try;

public class PackAdapter extends PackDao implements PackDbPort {


    @Override
    public Either<ApplicationError, Pack> save(Pack o) {
        PackEntity entity = fromDomain(o);
        return Try(() -> super.insert(entity))
                .toEither()
                .mapLeft(throwable -> new ApplicationError("Unable to save licence", null, o, throwable))
                .map(PackEntityMapper::toDomain);
    }

    @Override
    public Either<ApplicationError, List<Pack>> getAll() {
        return Try(() -> super.getList("SELECT * FROM pack;", PackEntity.class))
                .toEither()
                .mapLeft(throwable -> new ApplicationError("Unable to save licence", null, null, throwable))
                .map(PackEntityMapper::toDomainList);
    }

    @Override
    public Either<ApplicationError, Pack> getById(Integer id) {

        return Try(() -> super.get("SELECT * FROM pack WHERE id="+id + ";", PackEntity.class))
                .toEither()
                .mapLeft(throwable -> new ApplicationError("Unable to save licence", null, null, throwable))
                .map(PackEntityMapper::toDomain);
    }

    @Override
    public Either<ApplicationError, Pack> update(Pack o) {
            PackEntity entity = PackEntityMapper.fromDomain(o);

            return Try(() -> super.update(entity))
                    .toEither()
                    .mapLeft(throwable -> new ApplicationError("Unable to update pack", null, null, throwable))
                    .map(PackEntityMapper::toDomain);
    }

}
