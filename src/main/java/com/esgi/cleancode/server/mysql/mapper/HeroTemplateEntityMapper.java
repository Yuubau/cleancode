package com.esgi.cleancode.server.mysql.mapper;

import com.esgi.cleancode.domain.functional.model.Hero;
import com.esgi.cleancode.domain.functional.model.HeroTemplate;
import com.esgi.cleancode.server.mysql.entity.HeroEntity;
import com.esgi.cleancode.server.mysql.entity.HeroTemplateEntity;

import java.util.ArrayList;
import java.util.List;

public interface HeroTemplateEntityMapper {

  static HeroTemplate toDomain(HeroTemplateEntity entity) {
    return HeroTemplate.builder()
            .id(entity.getId())
            .name(entity.getName())
            .power(entity.getPower())
            .healthPoints(entity.getHealthPoints())
            .heroType(entity.getHeroType())
            .armor(entity.getArmor())
            .rarity(entity.getRarity())
            .build();
  }

  static HeroTemplateEntity fromDomain(HeroTemplate domain) {
    return HeroTemplateEntity.builder()
            .id(domain.getId())
            .name(domain.getName())
            .power(domain.getPower())
            .armor(domain.getArmor())
            .healthPoints(domain.getHealthPoints())
            .heroType(domain.getHeroType())
            .rarity(domain.getRarity())
            .build();
  }

  static List<HeroTemplate> toDomainList(List<HeroTemplateEntity> entities) {
    System.out.println(entities);
    List<HeroTemplate> l = new ArrayList<>();
    for (HeroTemplateEntity entity : entities) {
      l.add(toDomain(entity));
    }
    return l;
  }

  static List<HeroTemplateEntity> fromDomainList(List<HeroTemplate> domains) {
    List<HeroTemplateEntity> l = new ArrayList<>();
    for (HeroTemplate domain : domains) {
      l.add(fromDomain(domain));
    }
    return l;
  }
}
