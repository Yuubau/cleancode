package com.esgi.cleancode.domain.functional.service;

import com.esgi.cleancode.domain.functional.model.Hero;
import com.esgi.cleancode.domain.functional.model.HeroTemplate;
import com.esgi.cleancode.domain.ports.ApplicationError;
import com.esgi.cleancode.domain.ports.client.HeroCreatorPort;
import com.esgi.cleancode.domain.ports.client.HeroTemplateCreatorPort;
import com.esgi.cleancode.domain.ports.server.HeroDbPort;
import com.esgi.cleancode.domain.ports.server.HeroTemplateDbPort;
import io.vavr.control.Either;

public class HeroTemplateCreatorService implements HeroTemplateCreatorPort {

    private final HeroTemplateDbPort spi;

    public HeroTemplateCreatorService(HeroTemplateDbPort spi) {
        this.spi = spi;
    }

    @Override
    public Either<ApplicationError, HeroTemplate> create(HeroTemplate hero) {
        return spi.save(hero);
    }
}
