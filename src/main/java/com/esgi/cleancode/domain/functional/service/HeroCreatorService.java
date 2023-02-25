package com.esgi.cleancode.domain.functional.service;

import com.esgi.cleancode.domain.functional.model.Hero;
import com.esgi.cleancode.domain.ports.ApplicationError;
import com.esgi.cleancode.domain.ports.client.HeroCreatorPort;
import com.esgi.cleancode.domain.ports.server.HeroDbPort;
import io.vavr.control.Either;

public class HeroCreatorService implements HeroCreatorPort {

    private final HeroDbPort spi;

    public HeroCreatorService(HeroDbPort spi) {
        this.spi = spi;
    }

    @Override
    public Either<ApplicationError, Hero> create(Hero hero) {
        return spi.save(hero);
    }
}
