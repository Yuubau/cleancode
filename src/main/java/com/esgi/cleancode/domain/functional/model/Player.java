package com.esgi.cleancode.domain.functional.model;

import lombok.*;

@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Player {

    Integer id;
    @With  String pseudo;
    @With  Integer chipNumber;
    @With  Integer winCount;

}
