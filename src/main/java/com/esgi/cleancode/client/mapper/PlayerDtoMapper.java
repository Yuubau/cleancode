package com.esgi.cleancode.client.mapper;


import com.esgi.cleancode.client.dto.HeroDto;
import com.esgi.cleancode.client.dto.PlayerDto;
import com.esgi.cleancode.domain.functional.model.Hero;
import com.esgi.cleancode.domain.functional.model.Player;

import java.util.ArrayList;
import java.util.List;

public interface PlayerDtoMapper {

  static PlayerDto toDto(Player player) {
    return new PlayerDto(
            player.getId(),
            player.getPseudo(),
            player.getChipNumber(),
            player.getWinCount()
    );
  }

  static Player PlayerCreationToDomain(PlayerDto dto) {
    return Player.builder()
            .id(dto.getId())
            .chipNumber(dto.getChipNumber())
            .pseudo(dto.getPseudo())
            .winCount(dto.getWinCount())
            .build();
  }

  static List<PlayerDto> toDtoList(List<Player> players) {
    List<PlayerDto> l = new ArrayList<>();
    for (Player player : players){
      l.add(toDto(player));
    }
    return l;
  }

  static List<Player> PlayerCreationToDomainList(List<PlayerDto> dtos) {
    List<Player> l = new ArrayList<>();
    for (PlayerDto dto : dtos){
      l.add(PlayerCreationToDomain(dto));
    }
    return l;
  }
}
