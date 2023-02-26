package com.esgi.cleancode.domain.functional.service;

import com.esgi.cleancode.domain.functional.model.Hero;
import com.esgi.cleancode.domain.functional.model.Pack;
import com.esgi.cleancode.domain.ports.ApplicationError;
import com.esgi.cleancode.domain.ports.client.HeroCreatorPort;
import com.esgi.cleancode.domain.ports.client.PackCreatorPort;
import com.esgi.cleancode.domain.ports.server.HeroDbPort;
import com.esgi.cleancode.domain.ports.server.PackDbPort;
import io.vavr.control.Either;

public class PackCreatorService implements PackCreatorPort {

    private final PackDbPort spi;

    public PackCreatorService(PackDbPort spi) {
        this.spi = spi;
    }

    @Override
    public Either<ApplicationError, Pack> create(Pack pack) {
        return spi.save(pack);
    }
}
