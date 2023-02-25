package com.esgi.cleancode.server.mysql.adapter;

import com.esgi.cleancode.domain.functional.model.Hero;
import com.esgi.cleancode.domain.ports.ApplicationError;
import com.esgi.cleancode.domain.ports.server.HeroDbPort;
import com.esgi.cleancode.server.mysql.dao.HeroDao;
import com.esgi.cleancode.server.mysql.entity.HeroEntity;
import com.esgi.cleancode.server.mysql.mapper.HeroEntityMapper;
import io.vavr.control.Either;

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

}