package com.esgi.cleancode.domain.functional.service;

import com.esgi.cleancode.domain.functional.model.HeroTemplate;
import com.esgi.cleancode.domain.ports.ApplicationError;
import com.esgi.cleancode.domain.ports.client.HeroTemplateGetByIdPort;
import com.esgi.cleancode.domain.ports.server.HeroDbPort;
import com.esgi.cleancode.domain.ports.server.HeroTemplateDbPort;
import io.vavr.control.Either;

import java.util.List;

public class HeroTemplateGetByIdService implements HeroTemplateGetByIdPort {

    private final HeroTemplateDbPort spi;

    public HeroTemplateGetByIdService(HeroTemplateDbPort spi) {
        this.spi = spi;
    }

    @Override
    public Either<ApplicationError, HeroTemplate> getById(Integer id) {
        return spi.getById(id);
    }
}
