package com.esgi.cleancode.domain.ports.client;

import com.esgi.cleancode.domain.functional.model.Fight;
import com.esgi.cleancode.domain.functional.model.HeroTemplate;
import com.esgi.cleancode.domain.ports.ApplicationError;
import io.vavr.control.Either;

public interface FightStartPort {
    Either<ApplicationError, Fight> fight(Integer attackingHero, Integer defendingHero);
}
