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

    public Pack(Integer id, Integer name, Integer price, Integer cardNumber, Integer legendaryPercentage, Integer rarePercentage, Integer commonPercentage) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.cardNumber = cardNumber;
        this.legendaryPercentage = legendaryPercentage;
        this.rarePercentage = rarePercentage;
        this.commonPercentage = commonPercentage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getLegendaryPercentage() {
        return legendaryPercentage;
    }

    public void setLegendaryPercentage(Integer legendaryPercentage) {
        this.legendaryPercentage = legendaryPercentage;
    }

    public Integer getRarePercentage() {
        return rarePercentage;
    }

    public void setRarePercentage(Integer rarePercentage) {
        this.rarePercentage = rarePercentage;
    }

    public Integer getCommonPercentage() {
        return commonPercentage;
    }

    public void setCommonPercentage(Integer commonPercentage) {
        this.commonPercentage = commonPercentage;
    }
}
