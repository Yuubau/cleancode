package com.esgi.cleancode.client.mapper;


import com.esgi.cleancode.client.dto.PackDto;
import com.esgi.cleancode.domain.functional.model.Pack;

import java.util.ArrayList;
import java.util.List;

public interface PackDtoMapper {

  static PackDto toDto(Pack pack) {
    return new PackDto(
            pack.getId(),
            pack.getName(),
            pack.getCardNumber(),
            pack.getPrice(),
            pack.getCommonPercentage(),
            pack.getRarePercentage(),
            pack.getLegendaryPercentage()
    );
  }

  static Pack PackCreationToDomain(PackDto dto) {
    return Pack.builder()
            .id(dto.getId())
            .name(dto.getName())
            .price(dto.getPrice())
            .cardNumber(dto.getCardNumber())
            .commonPercentage(dto.getCommonPercentage())
            .rarePercentage(dto.getRarePercentage())
            .legendaryPercentage(dto.getLegendaryPercentage())
            .build();
  }

  static List<PackDto> toDtoList(List<Pack> packs) {
    List<PackDto> l = new ArrayList<>();
    for (Pack pack : packs){
      l.add(toDto(pack));
    }
    return l;
  }

  static List<Pack> PackCreationToDomainList(List<PackDto> dtos) {
    List<Pack> l = new ArrayList<>();
    for (PackDto dto : dtos){
      l.add(PackCreationToDomain(dto));
    }
    return l;
  }
}
