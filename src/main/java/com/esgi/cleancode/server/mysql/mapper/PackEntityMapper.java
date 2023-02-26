package com.esgi.cleancode.server.mysql.mapper;

import com.esgi.cleancode.domain.functional.model.Pack;
import com.esgi.cleancode.server.mysql.entity.PackEntity;

import java.util.ArrayList;
import java.util.List;

public interface PackEntityMapper {

  static Pack toDomain(PackEntity entity) {
    return Pack.builder()
            .id(entity.getId())
            .name(entity.getName())
            .price(entity.getPrice())
            .cardNumber(entity.getCardNumber())
            .commonPercentage(entity.getCommonPercentage())
            .rarePercentage(entity.getRarePercentage())
            .legendaryPercentage(entity.getLegendaryPercentage())
            .build();
  }

  static PackEntity fromDomain(Pack domain) {
    return PackEntity.builder()
            .id(domain.getId())
            .name(domain.getName())
            .cardNumber(domain.getCardNumber())
            .price(domain.getPrice())
            .commonPercentage(domain.getCommonPercentage())
            .rarePercentage(domain.getRarePercentage())
            .legendaryPercentage(domain.getLegendaryPercentage())
            .build();
  }

  static List<Pack> toDomainList(List<PackEntity> entities) {
    List<Pack> l = new ArrayList<>();
    for(PackEntity entity:entities) {
      l.add(toDomain(entity));
    }
    return l;
  }

  static List<PackEntity> fromDomainList(List<Pack> domains) {
    List<PackEntity> l = new ArrayList<>();
    for(Pack domain:domains) {
      l.add(fromDomain(domain));
    }
    return l;
  }
}
