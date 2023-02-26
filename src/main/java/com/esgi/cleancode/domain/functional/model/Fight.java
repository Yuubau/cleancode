package com.esgi.cleancode.domain.functional.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fight {

        Integer id;
        @With  Integer attackingHeroId;
        @With Integer defendingHeroId;
        @With  Boolean attackerWin;

}
