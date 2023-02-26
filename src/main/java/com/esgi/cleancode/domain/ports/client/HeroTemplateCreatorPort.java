package com.esgi.cleancode.domain.ports.client;

import com.esgi.cleancode.domain.functional.model.HeroTemplate;
import com.esgi.cleancode.domain.ports.ApplicationError;
import io.vavr.control.Either;

public interface HeroTemplateCreatorPort {
    Either<ApplicationError, HeroTemplate> create(HeroTemplate heroTemplate);
}
