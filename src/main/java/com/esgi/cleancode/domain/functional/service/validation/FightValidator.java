package com.esgi.cleancode.domain.functional.service.validation;

import com.esgi.cleancode.domain.functional.model.Fight;
import com.esgi.cleancode.domain.ports.ApplicationError;
import io.vavr.control.Validation;

import static io.vavr.API.Invalid;
import static io.vavr.API.Valid;

public interface FightValidator {

  static Validation<ApplicationError, Fight> validate(Fight fight) {
    return fight.getDefendingHeroId() == null || fight.getAttackingHeroId() == null || fight.getAttackerWin() == null
            ? Invalid(
            new ApplicationError(
                    "Label required", "You must provide an offence label", fight, null))
            : Valid(fight);
  }
}