package com.esgi.cleancode.domain.functional.model;

import com.esgi.cleancode.server.driver.annotation.DbColumnName;
import com.esgi.cleancode.server.driver.annotation.DbColumnType;
import com.esgi.cleancode.server.driver.annotation.DbTableName;

@DbTableName(value = "player")
public class Player {

    @DbColumnName(value = "id")
    @DbColumnType(type = Integer.class)
    private Integer id;

    @DbColumnName(value = "pseudo")
    @DbColumnType(type = String.class)
    private String pseudo;

    @DbColumnName(value = "chip_number")
    @DbColumnType(type = Integer.class)
    private Integer chip_number;

    @DbColumnName(value = "win_count")
    @DbColumnType(type = Integer.class)
    private Integer winCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Integer getChip_number() {
        return chip_number;
    }

    public void setChip_number(Integer chip_number) {
        this.chip_number = chip_number;
    }

    public Integer getWinCount() {
        return winCount;
    }

    public void setWinCount(Integer winCount) {
        this.winCount = winCount;
    }
}
