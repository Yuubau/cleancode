package com.esgi.cleancode.domain.ports.client;

import com.esgi.cleancode.domain.functional.model.Hero;
import com.esgi.cleancode.domain.ports.ApplicationError;
import io.vavr.control.Either;

import java.util.List;

public interface HeroGetPlayerHeroPort {
    Either<ApplicationError, List<Hero>> getPlayerHero(Integer id);

}
