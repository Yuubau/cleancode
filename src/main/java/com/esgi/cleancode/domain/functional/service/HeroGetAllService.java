package com.esgi.cleancode.domain.functional.service;

import com.esgi.cleancode.domain.functional.model.HeroTemplate;
import com.esgi.cleancode.domain.ports.ApplicationError;
import com.esgi.cleancode.domain.ports.client.HeroGetAllPort;
import com.esgi.cleancode.domain.ports.client.HeroTemplateGetAllPort;
import com.esgi.cleancode.domain.ports.server.HeroDbPort;
import com.esgi.cleancode.domain.ports.server.HeroTemplateDbPort;
import io.vavr.control.Either;

import java.util.List;

public class HeroGetAllService implements HeroGetAllPort {

    private final HeroDbPort spi;

    public HeroGetAllService(HeroDbPort spi) {
        this.spi = spi;
    }

    @Override
    public Either<ApplicationError, List<HeroTemplate>> getAll() {
        return null;
    }
}