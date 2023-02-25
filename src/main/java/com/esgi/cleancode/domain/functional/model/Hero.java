package com.esgi.cleancode.domain.functional.model;

import lombok.*;


@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Hero {

     Integer id;
    @With  Integer experiencePoints;
    @With  Integer playerId;
    @With  Integer heroId;
    @With  Integer level;

}
