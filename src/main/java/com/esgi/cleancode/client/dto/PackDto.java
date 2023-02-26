package com.esgi.cleancode.client.dto;

import com.esgi.cleancode.domain.functional.model.Pack;
import com.esgi.cleancode.domain.functional.model.Player;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
@NoArgsConstructor
public class PackDto extends Pack {

    public PackDto(Integer id, String name, Integer cardNumber, Integer price, Integer commonPercentage, Integer rarePercentage, Integer legendaryPercentage) {
        super(id, name, price, cardNumber, commonPercentage, rarePercentage, legendaryPercentage);
    }
}
