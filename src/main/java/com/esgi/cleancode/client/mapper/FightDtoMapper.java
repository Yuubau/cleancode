package com.esgi.cleancode.client.mapper;


import com.esgi.cleancode.client.dto.FightDto;
import com.esgi.cleancode.domain.functional.model.Fight;

import java.util.ArrayList;
import java.util.List;

public interface FightDtoMapper {

  static FightDto toDto(Fight fight) {
    return new FightDto(
            fight.getId(),
            fight.getAttackingHeroId(),
            fight.getDefendingHeroId(),
            fight.getAttackerWin()
    );
  }

  static Fight FightCreationToDomain(FightDto dto) {
    return new Fight(
            dto.getId(),
            dto.getAttackingHeroId(),
            dto.getDefendingHeroId(),
            dto.getAttackerWin()
    );
  }

  static List<FightDto> toDtoList(List<Fight> fightes) {
    List<FightDto> l = new ArrayList<>();
    for (Fight fight : fightes){
      l.add(new FightDto(
              fight.getId(),
              fight.getAttackingHeroId(),
              fight.getDefendingHeroId(),
              fight.getAttackerWin()
      ));
    }
    return l;
  }

  static List<Fight> FightCreationToDomainList(List<FightDto> dtos) {
    List<Fight> l = new ArrayList<>();
    for (FightDto dto : dtos){
      l.add(new Fight(
              dto.getId(),
              dto.getAttackingHeroId(),
              dto.getDefendingHeroId(),
              dto.getAttackerWin()
              )
      );
    }
    return l;
  }
}
