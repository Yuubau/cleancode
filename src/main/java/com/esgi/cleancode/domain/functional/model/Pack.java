package com.esgi.cleancode.domain.functional.model;

import lombok.*;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Pack {

        Integer id;
        @With  String name;
        @With  Integer price;
        @With Integer cardNumber;
        @With  Integer legendaryPercentage;
        @With  Integer rarePercentage;
        @With  Integer commonPercentage;

}
