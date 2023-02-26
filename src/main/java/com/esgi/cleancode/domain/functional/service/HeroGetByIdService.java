package com.esgi.cleancode.domain.functional.service;

import com.esgi.cleancode.domain.functional.model.Hero;
import com.esgi.cleancode.domain.functional.model.HeroTemplate;
import com.esgi.cleancode.domain.ports.ApplicationError;
import com.esgi.cleancode.domain.ports.client.HeroGetByIdPort;
import com.esgi.cleancode.domain.ports.server.HeroDbPort;
import io.vavr.control.Either;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HeroGetByIdService implements HeroGetByIdPort {

    private final HeroDbPort spi;

    public HeroGetByIdService(HeroDbPort spi) {
        this.spi = spi;
    }

    @Override
    public Either<ApplicationError, Hero> getById(Integer id) {

        return spi.getById(id);
    }
}