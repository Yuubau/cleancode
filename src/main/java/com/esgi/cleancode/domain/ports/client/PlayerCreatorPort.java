package com.esgi.cleancode.domain.ports.client;

import com.esgi.cleancode.domain.functional.model.Hero;
import com.esgi.cleancode.domain.functional.model.Player;
import com.esgi.cleancode.domain.ports.ApplicationError;
import io.vavr.control.Either;

import java.util.Optional;

public interface PlayerCreatorPort {
    Either<ApplicationError, Player> create(Player player);

}
