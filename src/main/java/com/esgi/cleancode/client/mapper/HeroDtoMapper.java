package com.esgi.cleancode.client.mapper;


import com.esgi.cleancode.client.dto.HeroDto;
import com.esgi.cleancode.domain.functional.model.Hero;

import java.util.ArrayList;
import java.util.List;

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

  static List<HeroDto> toDtoList(List<Hero> heroes) {
    List<HeroDto> l = new ArrayList<>();
    for (Hero hero : heroes){
      l.add(new HeroDto(
              hero.getId(),
              hero.getExperiencePoints(),
              hero.getPlayerId(),
              hero.getHeroId(),
              hero.getLevel()
      ));
    }
    return l;
  }

  static List<Hero> HeroCreationToDomainList(List<HeroDto> dtos) {
    List<Hero> l = new ArrayList<>();
    for (HeroDto dto : dtos){
      l.add(Hero.builder()
              .id(dto.getId())
              .heroId(dto.getHeroId())
              .level(dto.getLevel())
              .experiencePoints(dto.getExperiencePoints())
              .playerId(dto.getPlayerId())
              .build()
      );
    }
    return l;
  }
}
