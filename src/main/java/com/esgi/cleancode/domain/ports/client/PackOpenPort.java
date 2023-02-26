package com.esgi.cleancode.domain.ports.client;

import com.esgi.cleancode.domain.functional.model.Hero;
import com.esgi.cleancode.domain.functional.model.HeroTemplate;
import com.esgi.cleancode.domain.functional.model.Pack;
import com.esgi.cleancode.domain.ports.ApplicationError;
import io.vavr.control.Either;

import java.util.List;
import java.util.Optional;

public interface PackOpenPort {
    Either<ApplicationError, List<HeroTemplate>> openPack(Integer playerId, Integer packId);

}
