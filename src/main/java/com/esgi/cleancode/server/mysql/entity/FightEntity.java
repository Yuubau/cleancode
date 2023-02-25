package com.esgi.cleancode.server.mysql.entity;

import com.esgi.cleancode.server.mysql.driver.annotation.DbColumnName;
import com.esgi.cleancode.server.mysql.driver.annotation.DbColumnType;
import com.esgi.cleancode.server.mysql.driver.annotation.DbTableName;

@DbTableName(value = "fight")
public class FightEntity {

    @DbColumnName(value = "id")
    @DbColumnType(type = Integer.class)
    private Integer id;

    @DbColumnName(value = "attacking_hero_id")
    @DbColumnType(type = Integer.class)
    private Integer attackingHeroId;

    @DbColumnName(value = "defending_hero_id")
    @DbColumnType(type = Integer.class)
    private Integer defendingHeroId;

    @DbColumnName(value = "winner_hero_id")
    @DbColumnType(type = Integer.class)
    private Integer attackerWin;


    public FightEntity(Integer id, Integer attackingHeroId, Integer defendingHeroId, Integer winnerHeroId) {
        this.id = id;
        this.attackingHeroId = attackingHeroId;
        this.defendingHeroId = defendingHeroId;
        this.attackerWin = winnerHeroId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAttackingHeroId() {
        return attackingHeroId;
    }

    public void setAttackingHeroId(Integer attackingHeroId) {
        this.attackingHeroId = attackingHeroId;
    }

    public Integer getDefendingHeroId() {
        return defendingHeroId;
    }

    public void setDefendingHeroId(Integer defendingHeroId) {
        this.defendingHeroId = defendingHeroId;
    }

    public Integer getWinnerHeroId() {
        return attackerWin;
    }

    public void setWinnerHeroId(Integer winnerHeroId) {
        this.attackerWin = winnerHeroId;
    }

}
