package com.esgi.cleancode.domain.functional.service;

import com.esgi.cleancode.domain.functional.model.Hero;
import com.esgi.cleancode.domain.functional.service.validation.HeroValidator;
import com.esgi.cleancode.domain.ports.ApplicationError;
import com.esgi.cleancode.domain.ports.client.HeroCreatorPort;
import com.esgi.cleancode.domain.ports.server.HeroDbPort;
import io.vavr.control.Either;
import lombok.extern.slf4j.Slf4j;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HeroCreatorService implements HeroCreatorPort {

    private final HeroDbPort spi;

    public HeroCreatorService(HeroDbPort spi) {
        this.spi = spi;
    }

    @Override
    public Either<ApplicationError, Hero> create(Hero hero) {
        HeroValidator.validate(hero)
                .toEither()
                .peekLeft(
                        error -> log.error("An error occurred while validating Hero : {}", error))
                .flatMap(spi::save);
        return spi.save(hero);
    }
}
