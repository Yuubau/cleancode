package com.esgi.cleancode.domain.functional.model;

import com.esgi.cleancode.server.driver.annotation.DbColumnName;
import com.esgi.cleancode.server.driver.annotation.DbColumnType;
import com.esgi.cleancode.server.driver.annotation.DbTableName;

@DbTableName(value = "hero_template")
public class HeroTemplate {

    @DbColumnName(value = "id")
    @DbColumnType(type = Integer.class)
    private Integer id;

}
