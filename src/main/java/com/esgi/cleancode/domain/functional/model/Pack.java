package com.esgi.cleancode.domain.functional.model;


import com.esgi.cleancode.server.driver.annotation.DbColumnName;
import com.esgi.cleancode.server.driver.annotation.DbColumnType;
import com.esgi.cleancode.server.driver.annotation.DbTableName;

@DbTableName(value = "pack")
public class Pack {

    @DbColumnName(value = "id")
    @DbColumnType(type = Integer.class)
    private Integer id;

    @DbColumnName(value = "name")
    @DbColumnType(type = String.class)
    private Integer name;

    @DbColumnName(value = "price")
    @DbColumnType(type = Integer.class)
    private Integer price;

    @DbColumnName(value = "card_number")
    @DbColumnType(type = Integer.class)
    private Integer cardNumber;

    @DbColumnName(value = "legendary_percentage")
    @DbColumnType(type = Integer.class)
    private Integer legendaryPercentage;

    @DbColumnName(value = "rare_percentage")
    @DbColumnType(type = Integer.class)
    private Integer rarePercentage;

    @DbColumnName(value = "common_percentage")
    @DbColumnType(type = Integer.class)
    private Integer  commonPercentage;
}
