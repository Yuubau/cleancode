package com.esgi.cleancode.server.mysql.mapper;

import com.esgi.cleancode.domain.functional.model.Player;
import com.esgi.cleancode.server.mysql.entity.PlayerEntity;

import java.util.ArrayList;
import java.util.List;

public interface PlayerEntityMapper {

  static Player toDomain(PlayerEntity entity) {
    return Player.builder()
            .id(entity.getId())
            .pseudo(entity.getPseudo())
            .chipNumber(entity.getChipNumber())
            .winCount(entity.getWinCount())
            .build();
  }

  static PlayerEntity fromDomain(Player domain) {
    return PlayerEntity.builder()
            .id(domain.getId())
            .id(domain.getId())
            .pseudo(domain.getPseudo())
            .chipNumber(domain.getChipNumber())
            .winCount(domain.getWinCount())
            .build();
  }

  static List<Player> toDomainList(List<PlayerEntity> entities) {
    List<Player> l = new ArrayList<>();
    for(PlayerEntity entity:entities) {
      l.add(toDomain(entity));
    }
    return l;
  }

  static List<PlayerEntity> fromDomainList(List<Player> domains) {
    List<PlayerEntity> l = new ArrayList<>();
    for(Player domain:domains) {
      l.add(fromDomain(domain));
    }
    return l;
  }
}
