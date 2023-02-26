package com.esgi.cleancode.server.mysql.entity;

import com.esgi.cleancode.server.mysql.driver.annotation.DbColumnName;
import com.esgi.cleancode.server.mysql.driver.annotation.DbColumnType;
import com.esgi.cleancode.server.mysql.driver.annotation.DbTableName;
import com.esgi.cleancode.server.mysql.driver.util.GenericDb;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@DbTableName(value = "player")
@NoArgsConstructor
@AllArgsConstructor
public class PlayerEntity extends GenericDb {

    @DbColumnName(value = "id")
    @DbColumnType(type = Integer.class)
    private Integer id;

    @DbColumnName(value = "pseudo")
    @DbColumnType(type = String.class)
    private String pseudo;

    @DbColumnName(value = "chip_number")
    @DbColumnType(type = Integer.class)
    private Integer chipNumber;

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

    public Integer getChipNumber() {
        return chipNumber;
    }

    public void setChipNumber(Integer chip_number) {
        this.chipNumber = chip_number;
    }

    public Integer getWinCount() {
        return winCount;
    }

    public void setWinCount(Integer winCount) {
        this.winCount = winCount;
    }
}
