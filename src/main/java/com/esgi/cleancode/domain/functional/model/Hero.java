package com.esgi.cleancode.domain.functional.model;

import com.esgi.cleancode.server.driver.annotation.DbColumnName;
import com.esgi.cleancode.server.driver.annotation.DbColumnType;
import com.esgi.cleancode.server.driver.annotation.DbTableName;

@DbTableName(value = "hero")
public class Hero {

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

}
