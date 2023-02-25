package com.esgi.cleancode.server.mysql.mapper;

import com.esgi.cleancode.domain.functional.model.Hero;
import com.esgi.cleancode.server.mysql.entity.HeroEntity;

public interface HeroEntityMapper {

  static Hero toDomain(HeroEntity entity) {
    return Hero.builder()
            .id(entity.getId())
            .heroId(entity.getHeroId())
            .level(entity.getLevel())
            .experiencePoints(entity.getExperiencePoints())
            .playerId(entity.getPlayerId())
            .build();
  }

  static HeroEntity fromDomain(Hero domain) {
    return HeroEntity.builder()
            .id(domain.getId())
            .heroId(domain.getHeroId())
            .level(domain.getLevel())
            .experiencePoints(domain.getExperiencePoints())
            .playerId(domain.getPlayerId())
            .build();
  }
}
