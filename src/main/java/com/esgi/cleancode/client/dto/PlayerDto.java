package com.esgi.cleancode.client.dto;

import com.esgi.cleancode.domain.functional.model.Hero;
import com.esgi.cleancode.domain.functional.model.Player;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
@NoArgsConstructor
public class PlayerDto extends Player {
    public PlayerDto(Integer id, String pseudo, Integer chipNumber, Integer winCount) {
        super(id, pseudo, chipNumber, winCount);
    }

}
