package com.esgi.cleancode.domain.functional.service;

import com.esgi.cleancode.domain.functional.model.Fight;
import com.esgi.cleancode.domain.functional.model.Hero;
import com.esgi.cleancode.domain.ports.ApplicationError;
import com.esgi.cleancode.domain.ports.client.FightGetAllPort;
import com.esgi.cleancode.domain.ports.client.HeroGetPlayerHeroPort;
import com.esgi.cleancode.domain.ports.server.FightDbPort;
import com.esgi.cleancode.domain.ports.server.HeroDbPort;
import io.vavr.control.Either;

import java.util.List;

public class HeroGetPlayerHeroService implements HeroGetPlayerHeroPort {

    private final HeroDbPort spi;

    public HeroGetPlayerHeroService(HeroDbPort spi) {
        this.spi = spi;
    }

    @Override
    public Either<ApplicationError, List<Hero>> getPlayerHero(Integer id) {
        return spi.getPlayerHero(id);
    }
}