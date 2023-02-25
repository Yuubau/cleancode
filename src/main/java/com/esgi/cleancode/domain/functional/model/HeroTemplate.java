package com.esgi.cleancode.domain.functional.model;

import com.esgi.cleancode.server.driver.annotation.DbColumnName;
import com.esgi.cleancode.server.driver.annotation.DbColumnType;
import com.esgi.cleancode.server.driver.annotation.DbTableName;

@DbTableName(value = "hero_template")
public class HeroTemplate {

    @DbColumnName(value = "id")
    @DbColumnType(type = Integer.class)
    private Integer id;

    @DbColumnName(value = "name")
    @DbColumnType(type = String.class)
    private String name;

    @DbColumnName(value = "health_points")
    @DbColumnType(type = String.class)
    private String healthPoints;

    @DbColumnName(value = "power")
    @DbColumnType(type = Integer.class)
    private Integer power;

    @DbColumnName(value = "armor")
    @DbColumnType(type = Integer.class)
    private Integer armor;

    @DbColumnName(value = "rarity")
    @DbColumnType(type = String.class)
    private String rarity;

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

    public String getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(String healthPoints) {
        this.healthPoints = healthPoints;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getArmor() {
        return armor;
    }

    public void setArmor(Integer armor) {
        this.armor = armor;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }
}
