package com.esgi.cleancode.domain.functional.service;

import com.esgi.cleancode.domain.functional.model.Fight;
import com.esgi.cleancode.domain.functional.service.validation.FightValidator;
import com.esgi.cleancode.domain.ports.ApplicationError;
import com.esgi.cleancode.domain.ports.client.FightCreatorPort;
import com.esgi.cleancode.domain.ports.server.FightDbPort;
import io.vavr.control.Either;

import java.util.logging.ErrorManager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FightCreatorService implements FightCreatorPort {

    private final FightDbPort spi;

    public FightCreatorService(FightDbPort spi) {
        this.spi = spi;
    }

    @Override
    public Either<ApplicationError, Fight> create(Fight fight) {
        return FightValidator.validate(fight)
                .toEither()
                .peekLeft(
                        error -> log.error("An error occurred while validating fight : {}", error))
                .flatMap(spi::save);
    }
}
