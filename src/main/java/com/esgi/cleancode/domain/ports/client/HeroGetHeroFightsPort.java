package com.esgi.cleancode.domain.ports.client;

import com.esgi.cleancode.domain.functional.model.Fight;
import com.esgi.cleancode.domain.functional.model.Hero;
import com.esgi.cleancode.domain.ports.ApplicationError;
import io.vavr.control.Either;

import java.util.List;

public interface HeroGetHeroFightsPort {
    Either<ApplicationError, List<Fight>> getHeroFights(Integer id);

}
