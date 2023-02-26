package com.esgi.cleancode.domain.ports.server;

import com.esgi.cleancode.domain.functional.model.Hero;
import com.esgi.cleancode.domain.ports.ApplicationError;
import com.esgi.cleancode.server.mysql.entity.HeroEntity;
import io.vavr.control.Either;

import java.util.List;

public interface HeroDbPort extends DbPort<Hero> {
    Either<ApplicationError, List<Hero>> getPlayerHero(Integer playerId);
}
