package com.esgi.cleancode.domain.functional.service;

import com.esgi.cleancode.domain.functional.model.Hero;
import com.esgi.cleancode.domain.functional.model.Player;
import com.esgi.cleancode.domain.functional.service.validation.PlayerValidator;
import com.esgi.cleancode.domain.ports.ApplicationError;
import com.esgi.cleancode.domain.ports.client.HeroCreatorPort;
import com.esgi.cleancode.domain.ports.client.PlayerCreatorPort;
import com.esgi.cleancode.domain.ports.server.HeroDbPort;
import com.esgi.cleancode.domain.ports.server.PlayerDbPort;
import io.vavr.control.Either;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PlayerCreatorService implements PlayerCreatorPort {

    private final PlayerDbPort spi;

    public PlayerCreatorService(PlayerDbPort spi) {
        this.spi = spi;
    }

    @Override
    public Either<ApplicationError, Player> create(Player player) {
        PlayerValidator.validate(player)
                .toEither()
                .peekLeft(
                        error -> log.error("An error occurred while validating player : {}", error))
                .flatMap(spi::save);
        return spi.save(player);
    }
}
