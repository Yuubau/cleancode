package com.esgi.cleancode.client.dto;

import com.esgi.cleancode.domain.functional.model.Fight;
import com.esgi.cleancode.domain.functional.model.Hero;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
@NoArgsConstructor
public class FightDto extends Fight {


    public FightDto(Integer id, Integer attackingHeroId, Integer defendingHeroId, Boolean attackerWin) {
        super(id, attackingHeroId, defendingHeroId, attackerWin);
    }
}
