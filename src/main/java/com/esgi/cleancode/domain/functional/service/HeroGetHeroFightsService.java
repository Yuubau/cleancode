package com.esgi.cleancode.domain.functional.service;

import com.esgi.cleancode.domain.functional.model.Fight;
import com.esgi.cleancode.domain.functional.model.Hero;
import com.esgi.cleancode.domain.ports.ApplicationError;
import com.esgi.cleancode.domain.ports.client.HeroGetAllPort;
import com.esgi.cleancode.domain.ports.client.HeroGetHeroFightsPort;
import com.esgi.cleancode.domain.ports.server.HeroDbPort;
import io.vavr.control.Either;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class HeroGetHeroFightsService implements HeroGetHeroFightsPort {

    private final HeroDbPort spi;

    public HeroGetHeroFightsService(HeroDbPort spi) {
        this.spi = spi;
    }

    @Override
    public Either<ApplicationError, List<Fight>> getHeroFights(Integer id) {
        return spi.getHeroFights(id);
    }
}