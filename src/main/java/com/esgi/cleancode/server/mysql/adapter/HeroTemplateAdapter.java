package com.esgi.cleancode.server.mysql.adapter;

import com.esgi.cleancode.domain.functional.model.Hero;
import com.esgi.cleancode.domain.functional.model.HeroTemplate;
import com.esgi.cleancode.domain.ports.ApplicationError;
import com.esgi.cleancode.domain.ports.server.HeroDbPort;
import com.esgi.cleancode.domain.ports.server.HeroTemplateDbPort;
import com.esgi.cleancode.server.mysql.dao.HeroDao;
import com.esgi.cleancode.server.mysql.dao.HeroTemplateDao;
import com.esgi.cleancode.server.mysql.entity.HeroEntity;
import com.esgi.cleancode.server.mysql.entity.HeroTemplateEntity;
import com.esgi.cleancode.server.mysql.mapper.HeroEntityMapper;
import com.esgi.cleancode.server.mysql.mapper.HeroTemplateEntityMapper;
import io.vavr.control.Either;

import java.util.List;

import static com.esgi.cleancode.server.mysql.mapper.HeroTemplateEntityMapper.fromDomain;
import static io.vavr.API.Try;

public class HeroTemplateAdapter extends HeroTemplateDao implements HeroTemplateDbPort {


    @Override
    public Either<ApplicationError, HeroTemplate> save(HeroTemplate o) {
        HeroTemplateEntity entity = HeroTemplateEntityMapper.fromDomain(o);
        return Try(() -> super.insert(entity))
                .toEither()
                .mapLeft(throwable -> new ApplicationError("Unable to save licence", null, o, throwable))
                .map(HeroTemplateEntityMapper::toDomain);
    }

    @Override
    public Either<ApplicationError, List<HeroTemplate>> getAll() {
        return Try(() -> super.getList(
                "select * from hero_template;", HeroTemplateEntity.class
        ))
                .toEither()
                .mapLeft(throwable -> new ApplicationError("Unable to save licence", null, null, throwable))
                .map(
                        HeroTemplateEntityMapper::toDomainList
                );
    }

}
