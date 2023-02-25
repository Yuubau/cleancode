package com.esgi.cleancode.client.dto;

import com.esgi.cleancode.domain.functional.model.Hero;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
@NoArgsConstructor
public class HeroDto extends Hero {

    public HeroDto(Integer id, Integer experiencePoints, Integer playerId, Integer heroId, Integer level) {
        super(id, experiencePoints, playerId, heroId, level);
    }
}
