package com.esgi.cleancode.domain.ports.client;

import com.esgi.cleancode.domain.functional.model.Hero;
import com.esgi.cleancode.domain.functional.model.HeroTemplate;
import com.esgi.cleancode.domain.ports.ApplicationError;
import io.vavr.control.Either;

public interface HeroGetByIdPort {
    Either<ApplicationError, Hero> getById(Integer id);
}
