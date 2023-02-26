package com.esgi.cleancode.server.mysql.mapper;

import com.esgi.cleancode.domain.functional.model.Fight;
import com.esgi.cleancode.server.mysql.entity.FightEntity;

import java.util.ArrayList;
import java.util.List;

public interface FightEntityMapper {

  static Fight toDomain(FightEntity entity) {
    return  new Fight(
            entity.getId(),
            entity.getAttackingHeroId(),
            entity.getDefendingHeroId(),
            entity.getAttackerWin()
    );
  }

  static FightEntity fromDomain(Fight domain) {
    return new FightEntity(
            domain.getId(),
            domain.getAttackingHeroId(),
            domain.getDefendingHeroId(),
            domain.getAttackerWin()
    );
  }

  static List<Fight> toDomainList(List<FightEntity> entities) {
    List<Fight> l = new ArrayList<>();
    for (FightEntity entity : entities) {
      l.add(toDomain(entity));
    }
    return l;
  }

  static List<FightEntity> fromDomainList(List<Fight> domains) {
    List<FightEntity> l = new ArrayList<>();
    for (Fight domain : domains) {
      l.add(fromDomain(domain));
    }
    return l;
  }
}
