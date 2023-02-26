package com.esgi.cleancode.domain.ports.client;

import com.esgi.cleancode.domain.functional.model.Fight;
import com.esgi.cleancode.domain.functional.model.Pack;
import com.esgi.cleancode.domain.ports.ApplicationError;
import io.vavr.control.Either;

public interface FightCreatorPort {
    Either<ApplicationError, Fight> create(Fight fight);
}
