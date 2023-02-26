package com.esgi.cleancode.domain.ports.client;

import com.esgi.cleancode.domain.functional.model.HeroTemplate;
import com.esgi.cleancode.domain.ports.ApplicationError;
import io.vavr.control.Either;

import java.util.List;

public interface HeroTemplateGetAllPort {
    Either<ApplicationError, List<HeroTemplate>> getAll();
}
