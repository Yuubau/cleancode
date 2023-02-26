package com.esgi.cleancode.domain.functional.service;

import com.esgi.cleancode.domain.functional.model.Player;
import com.esgi.cleancode.domain.ports.ApplicationError;
import com.esgi.cleancode.domain.ports.client.PlayerGetByIdPort;
import com.esgi.cleancode.domain.ports.server.PlayerDbPort;
import io.vavr.control.Either;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PlayerGetByIdService implements PlayerGetByIdPort {

    private final PlayerDbPort spi;

    public PlayerGetByIdService(PlayerDbPort spi) {
        this.spi = spi;
    }

    @Override
    public Either<ApplicationError, Player> getById(Integer id) {

        return spi.getById(id);
    }
}