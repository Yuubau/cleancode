package com.esgi.cleancode.client.dto;

import com.esgi.cleancode.domain.functional.model.HeroTemplate;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
@NoArgsConstructor
public class HeroTemplateDto extends HeroTemplate {


    public HeroTemplateDto(Integer id, String name, Integer power, Integer armor, Integer rarity, Integer heroType, Integer healthPoints) {
        super(id, name, power, armor, rarity, heroType, healthPoints);
    }
}
