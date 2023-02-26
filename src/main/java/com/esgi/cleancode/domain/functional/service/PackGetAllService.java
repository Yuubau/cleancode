package com.esgi.cleancode.domain.functional.service;

import com.esgi.cleancode.domain.functional.model.Pack;
import com.esgi.cleancode.domain.functional.model.Player;
import com.esgi.cleancode.domain.ports.ApplicationError;
import com.esgi.cleancode.domain.ports.client.PackGetAllPort;
import com.esgi.cleancode.domain.ports.client.PlayerGetAllPort;
import com.esgi.cleancode.domain.ports.server.PackDbPort;
import com.esgi.cleancode.domain.ports.server.PlayerDbPort;
import io.vavr.control.Either;

import java.util.List;

public class PackGetAllService implements PackGetAllPort {

    private final PackDbPort spi;

    public PackGetAllService(PackDbPort spi) {
        this.spi = spi;
    }

    @Override
    public Either<ApplicationError, List<Pack>> getAll() {
        return spi.getAll();
    }
}