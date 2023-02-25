package com.esgi.cleancode.client.mapper;


import com.esgi.cleancode.client.dto.HeroDto;
import com.esgi.cleancode.domain.functional.model.Hero;

public interface HeroDtoMapper {

  static HeroDto toDto(Hero hero) {
    return new HeroDto(
            hero.getId(),
            hero.getExperiencePoints(),
            hero.getPlayerId(),
            hero.getHeroId(),
            hero.getLevel()
    );
  }

  static Hero HeroCreationToDomain(HeroDto dto) {
    return Hero.builder()
            .id(dto.getId())
            .heroId(dto.getHeroId())
            .level(dto.getLevel())
            .experiencePoints(dto.getExperiencePoints())
            .playerId(dto.getPlayerId())
            .build();
  }
}
