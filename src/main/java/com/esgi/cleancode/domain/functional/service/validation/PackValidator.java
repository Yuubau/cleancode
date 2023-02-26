package com.esgi.cleancode.domain.functional.service.validation;

import com.esgi.cleancode.domain.functional.model.Pack;
import com.esgi.cleancode.domain.ports.ApplicationError;
import io.vavr.control.Validation;

import static io.vavr.API.Invalid;
import static io.vavr.API.Valid;

public interface PackValidator {

  static Validation<ApplicationError, Pack> validate(Pack pack) {
    return pack.getLegendaryPercentage() == null || pack.getCommonPercentage() == null || pack.getRarePercentage() == null
            || pack.getName() == null || pack.getPrice() == null || pack.getCardNumber() == null
            ? Invalid(
            new ApplicationError(
                    "Label required", "You must provide an offence label", pack, null))
            : Valid(pack);
  }
}