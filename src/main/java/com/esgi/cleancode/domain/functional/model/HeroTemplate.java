package com.esgi.cleancode.domain.functional.model;

import lombok.*;


@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class HeroTemplate {

     Integer id;
    @With  String name;
    @With  Integer power;
    @With  Integer armor;
    @With  Integer rarity;
    @With  Integer heroType;
    @With  Integer healthPoints;

}
