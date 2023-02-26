package com.esgi.cleancode.domain.functional.service.validation;

import com.esgi.cleancode.domain.functional.model.Hero;
import com.esgi.cleancode.domain.ports.ApplicationError;
import io.vavr.control.Validation;

import static io.vavr.API.Invalid;
import static io.vavr.API.Valid;

public interface HeroValidator {

  static Validation<ApplicationError, Hero> validate(Hero hero) {
    return hero.getHeroId() == null || hero.getLevel() == null || hero.getExperiencePoints() == null || hero.getPlayerId() == null
            ? Invalid(
            new ApplicationError(
                    "Label required", "You must provide an offence label", hero, null))
            : Valid(hero);
  }
}