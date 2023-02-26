package com.esgi.cleancode.domain.functional.service;

import com.esgi.cleancode.domain.functional.model.Hero;
import com.esgi.cleancode.domain.functional.model.HeroTemplate;
import com.esgi.cleancode.domain.functional.service.validation.HeroTemplateValidator;
import com.esgi.cleancode.domain.ports.ApplicationError;
import com.esgi.cleancode.domain.ports.client.HeroCreatorPort;
import com.esgi.cleancode.domain.ports.client.HeroTemplateCreatorPort;
import com.esgi.cleancode.domain.ports.server.HeroDbPort;
import com.esgi.cleancode.domain.ports.server.HeroTemplateDbPort;
import io.vavr.control.Either;

import lombok.extern.slf4j.Slf4j;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HeroTemplateCreatorService implements HeroTemplateCreatorPort {

    private final HeroTemplateDbPort spi;

    public HeroTemplateCreatorService(HeroTemplateDbPort spi) {
        this.spi = spi;
    }

    @Override
    public Either<ApplicationError, HeroTemplate> create(HeroTemplate heroTemplate) {
        HeroTemplateValidator.validate(heroTemplate)
                .toEither()
                .peekLeft(
                        error -> log.error("An error occurred while validating Hero template : {}", error))
                .flatMap(spi::save);
        return spi.save(heroTemplate);
    }
}
