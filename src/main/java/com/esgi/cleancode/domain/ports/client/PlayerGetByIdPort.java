package com.esgi.cleancode.domain.ports.client;

import com.esgi.cleancode.domain.functional.model.Player;
import com.esgi.cleancode.domain.ports.ApplicationError;
import io.vavr.control.Either;

import java.util.List;

public interface PlayerGetByIdPort {

    Either<ApplicationError, Player> getById(Integer id);
}
