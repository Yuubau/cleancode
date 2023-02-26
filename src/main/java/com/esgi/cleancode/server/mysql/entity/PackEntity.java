package com.esgi.cleancode.server.mysql.entity;


import com.esgi.cleancode.server.mysql.driver.annotation.DbColumnName;
import com.esgi.cleancode.server.mysql.driver.annotation.DbColumnType;
import com.esgi.cleancode.server.mysql.driver.annotation.DbTableName;
import com.esgi.cleancode.server.mysql.driver.util.GenericDb;
import jdk.jshell.Snippet;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@DbTableName(value = "pack")
@NoArgsConstructor
public class PackEntity extends GenericDb {

    @DbColumnName(value = "id")
    @DbColumnType(type = Integer.class)
    private Integer id;

    @DbColumnName(value = "name")
    @DbColumnType(type = String.class)
    private String name;

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

    public PackEntity(Integer id, String name, Integer price, Integer cardNumber, Integer legendaryPercentage, Integer rarePercentage, Integer commonPercentage) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
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
