package com.esgi.cleancode.domain.functional.service;

import com.esgi.cleancode.domain.functional.model.Fight;
import com.esgi.cleancode.domain.functional.model.Pack;
import com.esgi.cleancode.domain.ports.ApplicationError;
import com.esgi.cleancode.domain.ports.client.FightGetAllPort;
import com.esgi.cleancode.domain.ports.client.PackGetAllPort;
import com.esgi.cleancode.domain.ports.server.FightDbPort;
import com.esgi.cleancode.domain.ports.server.PackDbPort;
import io.vavr.control.Either;

import java.util.List;

public class FightGetAllService implements FightGetAllPort {

    private final FightDbPort spi;

    public FightGetAllService(FightDbPort spi) {
        this.spi = spi;
    }

    @Override

    public Either<ApplicationError, List<Fight>> getAll() {
        return spi.getAll();
    }
}