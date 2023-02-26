package com.esgi.cleancode.domain.functional.service;

import com.esgi.cleancode.domain.functional.model.HeroTemplate;
import com.esgi.cleancode.domain.functional.model.Player;
import com.esgi.cleancode.domain.ports.ApplicationError;
import com.esgi.cleancode.domain.ports.client.HeroGetAllPort;
import com.esgi.cleancode.domain.ports.client.PlayerGetAllPort;
import com.esgi.cleancode.domain.ports.server.HeroDbPort;
import com.esgi.cleancode.domain.ports.server.PlayerDbPort;
import io.vavr.control.Either;

import java.util.List;

public class PlayerGetAllService implements PlayerGetAllPort {

    private final PlayerDbPort spi;

    public PlayerGetAllService(PlayerDbPort spi) {
        this.spi = spi;
    }

    @Override
    public Either<ApplicationError, List<Player>> getAll() {
        return spi.getAll();
    }
}