package com.esgi.cleancode.server.mysql.entity;

import com.esgi.cleancode.server.mysql.driver.annotation.DbColumnName;
import com.esgi.cleancode.server.mysql.driver.annotation.DbColumnType;
import com.esgi.cleancode.server.mysql.driver.annotation.DbTableName;
import com.esgi.cleancode.server.mysql.driver.util.GenericDb;
import lombok.Builder;
import lombok.With;

@DbTableName(value = "hero")
@Builder
public class HeroEntity extends GenericDb {

    @DbColumnName(value = "id")
    @DbColumnType(type = Integer.class)
    @With private Integer id;

    @DbColumnName(value = "experience_points")
    @DbColumnType(type = Integer.class)
    @With private Integer experiencePoints;

    @DbColumnName(value = "player_id")
    @DbColumnType(type = Integer.class)
    @With private Integer playerId;

    @DbColumnName(value = "hero_id")
    @DbColumnType(type = Integer.class)
    @With private Integer heroId;

    @DbColumnName(value = "level")
    @DbColumnType(type = Integer.class)
    @With
    private Integer level;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
