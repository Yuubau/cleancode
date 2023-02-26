package com.esgi.cleancode.domain.ports.client;

import com.esgi.cleancode.domain.functional.model.Hero;
import com.esgi.cleancode.domain.functional.model.Pack;
import com.esgi.cleancode.domain.ports.ApplicationError;
import io.vavr.control.Either;

public interface PackCreatorPort {
    Either<ApplicationError, Pack> create(Pack pack);
}
