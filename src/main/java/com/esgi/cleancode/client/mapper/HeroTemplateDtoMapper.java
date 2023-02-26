package com.esgi.cleancode.client.mapper;


import com.esgi.cleancode.client.dto.HeroDto;
import com.esgi.cleancode.client.dto.HeroTemplateDto;
import com.esgi.cleancode.domain.functional.model.Hero;
import com.esgi.cleancode.domain.functional.model.HeroTemplate;

import java.util.ArrayList;
import java.util.List;

public interface HeroTemplateDtoMapper {

  static HeroTemplateDto toDto(HeroTemplate heroTemplate) {
    return new HeroTemplateDto(
              heroTemplate.getId(),
              heroTemplate.getName(),
              heroTemplate.getPower(),
              heroTemplate.getArmor(),
              heroTemplate.getRarity(),
              heroTemplate.getHeroType(),
              heroTemplate.getHealthPoints()
            );
  }

  static HeroTemplate HeroTemplateCreationToDomain(HeroTemplateDto dto) {
    return HeroTemplate.builder()
            .id(dto.getId())
            .name(dto.getName())
            .power(dto.getPower())
            .armor(dto.getArmor())
            .rarity(dto.getRarity())
            .heroType(dto.getHeroType())
            .healthPoints(dto.getHealthPoints())
            .build();
  }

  static List<HeroTemplateDto> toDtoList(List<HeroTemplate> heroTemplates) {
    List<HeroTemplateDto> l = new ArrayList<>();
    for(HeroTemplate heroTemplate:heroTemplates) {
      l.add(new HeroTemplateDto(
              heroTemplate.getId(),
              heroTemplate.getName(),
              heroTemplate.getPower(),
              heroTemplate.getArmor(),
              heroTemplate.getRarity(),
              heroTemplate.getHeroType(),
              heroTemplate.getHealthPoints()
      ));
    }
    return l;
  }

  static List<HeroTemplate> HeroTemplateCreationToDomainList(List<HeroTemplateDto> dtos) {
    List<HeroTemplate> l = new ArrayList<>();
    for(HeroTemplateDto dto: dtos) {
      l.add(HeroTemplate.builder()
              .id(dto.getId())
              .name(dto.getName())
              .power(dto.getPower())
              .armor(dto.getArmor())
              .rarity(dto.getRarity())
              .heroType(dto.getHeroType())
              .healthPoints(dto.getHealthPoints())
              .build());
    }
    return l;
  }
}
