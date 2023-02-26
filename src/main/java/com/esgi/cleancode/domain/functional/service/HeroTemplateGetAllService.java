package com.esgi.cleancode.domain.functional.service;

import com.esgi.cleancode.domain.functional.model.HeroTemplate;
import com.esgi.cleancode.domain.ports.ApplicationError;
import com.esgi.cleancode.domain.ports.client.HeroTemplateCreatorPort;
import com.esgi.cleancode.domain.ports.client.HeroTemplateGetAllPort;
import com.esgi.cleancode.domain.ports.server.HeroTemplateDbPort;
import io.vavr.control.Either;

import java.util.List;

public class HeroTemplateGetAllService implements HeroTemplateGetAllPort {

    private final HeroTemplateDbPort spi;

    public HeroTemplateGetAllService(HeroTemplateDbPort spi) {
        this.spi = spi;
    }

    @Override
    public Either<ApplicationError, List<HeroTemplate>> getAll() {
        return spi.getAll();
    }
}