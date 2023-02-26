package com.esgi.cleancode.domain.functional.model;

import lombok.*;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Player {

    Integer id;
    @With  String pseudo;
    @With  Integer chipNumber;
    @With  Integer winCount;

}
