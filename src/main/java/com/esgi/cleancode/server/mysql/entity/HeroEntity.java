package com.esgi.cleancode.server.mysql.entity;

import com.esgi.cleancode.server.mysql.driver.annotation.DbColumnName;
import com.esgi.cleancode.server.mysql.driver.annotation.DbColumnType;
import com.esgi.cleancode.server.mysql.driver.annotation.DbTableName;

@DbTableName(value = "hero")
public class HeroEntity {

    @DbColumnName(value = "id")
    @DbColumnType(type = Integer.class)
    private Integer name;

    @DbColumnName(value = "experience_points")
    @DbColumnType(type = Integer.class)
    private Integer experiencePoints;

    @DbColumnName(value = "player_id")
    @DbColumnType(type = Integer.class)
    private Integer playerId;

    @DbColumnName(value = "hero_id")
    @DbColumnType(type = Integer.class)
    private Integer heroId;

    @DbColumnName(value = "level")
    @DbColumnType(type = Integer.class)
    private Integer level;

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public Integer getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(Integer experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getHeroId() {
        return heroId;
    }

    public void setHeroId(Integer heroId) {
        this.heroId = heroId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
