package com.esgi.cleancode.domain.ports.client;

import com.esgi.cleancode.domain.functional.model.Hero;
import com.esgi.cleancode.domain.functional.model.HeroTemplate;
import com.esgi.cleancode.domain.ports.ApplicationError;
import io.vavr.control.Either;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HeroGetAllPort {
    Either<ApplicationError, List<Hero>> getAll();

}
