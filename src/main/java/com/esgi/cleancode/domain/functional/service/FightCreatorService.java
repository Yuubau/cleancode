package com.esgi.cleancode.domain.functional.service;

import com.esgi.cleancode.domain.functional.model.Fight;
import com.esgi.cleancode.domain.ports.ApplicationError;
import com.esgi.cleancode.domain.ports.client.FightCreatorPort;
import com.esgi.cleancode.domain.ports.server.FightDbPort;
import io.vavr.control.Either;

public class FightCreatorService implements FightCreatorPort {

    private final FightDbPort spi;

    public FightCreatorService(FightDbPort spi) {
        this.spi = spi;
    }

    @Override
    public Either<ApplicationError, Fight> create(Fight fight) {
        return spi.save(fight);
    }
}
