package com.esgi.cleancode.domain.ports.client;

import com.esgi.cleancode.domain.functional.model.HeroTemplate;
import com.esgi.cleancode.domain.functional.model.Player;
import com.esgi.cleancode.domain.ports.ApplicationError;
import io.vavr.control.Either;

import java.util.List;

public interface PlayerGetAllPort {
    Either<ApplicationError, List<Player>> getAll();
}
