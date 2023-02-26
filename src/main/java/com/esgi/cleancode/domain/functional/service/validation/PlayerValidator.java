package com.esgi.cleancode.domain.functional.service.validation;

import com.esgi.cleancode.domain.functional.model.Player;
import com.esgi.cleancode.domain.ports.ApplicationError;
import io.vavr.control.Validation;

import static io.vavr.API.Invalid;
import static io.vavr.API.Valid;

public interface PlayerValidator {

  static Validation<ApplicationError, Player> validate(Player player) {
    System.out.println(player);
    return player.getPseudo() == null || player.getChipNumber() == null || player.getWinCount() == null
            ? Invalid(
            new ApplicationError(
                    "Label required", "You must provide an offence label", player, null))
            : Valid(player);
  }
}