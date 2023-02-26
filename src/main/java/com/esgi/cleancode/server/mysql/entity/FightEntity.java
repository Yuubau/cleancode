package com.esgi.cleancode.server.mysql.entity;

import com.esgi.cleancode.server.mysql.driver.annotation.DbColumnName;
import com.esgi.cleancode.server.mysql.driver.annotation.DbColumnType;
import com.esgi.cleancode.server.mysql.driver.annotation.DbTableName;
import com.esgi.cleancode.server.mysql.driver.util.GenericDb;
import lombok.NoArgsConstructor;

@DbTableName(value = "fight")
@NoArgsConstructor
public class FightEntity extends GenericDb {

    @DbColumnName(value = "id")
    @DbColumnType(type = Integer.class)
    private Integer id;

    @DbColumnName(value = "attacking_hero_id")
    @DbColumnType(type = Integer.class)
    private Integer attackingHeroId;

    @DbColumnName(value = "defending_hero_id")
    @DbColumnType(type = Integer.class)
    private Integer defendingHeroId;

    @DbColumnName(value = "attacker_win")
    @DbColumnType(type = Boolean.class)
    private Boolean attackerWin;


    public FightEntity(Integer id, Integer attackingHeroId, Integer defendingHeroId, Boolean attackerWin) {
        this.id = id;
        this.attackingHeroId = attackingHeroId;
        this.defendingHeroId = defendingHeroId;
        this.attackerWin = attackerWin;
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

    public Boolean getWinnerHeroId() {
        return attackerWin;
    }

    public void setWinnerHeroId(Boolean winnerHeroId) {
        this.attackerWin = winnerHeroId;
    }

    public Boolean getAttackerWin() {
        return attackerWin;
    }

    public void setAttackerWin(Boolean attackerWin) {
        this.attackerWin = attackerWin;
    }
}
