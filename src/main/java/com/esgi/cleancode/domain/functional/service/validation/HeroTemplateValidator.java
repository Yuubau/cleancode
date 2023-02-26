package com.esgi.cleancode.domain.functional.service.validation;

import com.esgi.cleancode.domain.functional.model.Hero;
import com.esgi.cleancode.domain.functional.model.HeroTemplate;
import com.esgi.cleancode.domain.ports.ApplicationError;
import io.vavr.control.Validation;

import static io.vavr.API.Invalid;
import static io.vavr.API.Valid;

public interface HeroTemplateValidator {

  static Validation<ApplicationError, HeroTemplate> validate(HeroTemplate heroTemplate) {
    return heroTemplate.getHealthPoints() == null || heroTemplate.getName() == null || heroTemplate.getRarity() == null
            || heroTemplate.getArmor() == null || heroTemplate.getPower() == null || heroTemplate.getHeroType() == null
            ? Invalid(
            new ApplicationError(
                    "Label required", "You must provide an offence label", heroTemplate, null))
            : Valid(heroTemplate);
  }
}