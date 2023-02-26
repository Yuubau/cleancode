package com.esgi.cleancode.server.mysql.entity;

import com.esgi.cleancode.server.mysql.driver.annotation.DbColumnName;
import com.esgi.cleancode.server.mysql.driver.annotation.DbColumnType;
import com.esgi.cleancode.server.mysql.driver.annotation.DbTableName;
import com.esgi.cleancode.server.mysql.driver.util.GenericDb;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DbTableName(value = "hero_template")
public class HeroTemplateEntity extends GenericDb {

    @DbColumnName(value = "id")
    @DbColumnType(type = Integer.class)
    private Integer id;

    @DbColumnName(value = "name")
    @DbColumnType(type = String.class)
    private String name;

    @DbColumnName(value = "health_points")
    @DbColumnType(type = Integer.class)
    private Integer healthPoints;

    @DbColumnName(value = "power")
    @DbColumnType(type = Integer.class)
    private Integer power;

    @DbColumnName(value = "armor")
    @DbColumnType(type = Integer.class)
    private Integer armor;

    @DbColumnName(value = "rarity")
    @DbColumnType(type = Integer.class)
    private Integer rarity;

    @DbColumnName(value = "hero_type")
    @DbColumnType(type = Integer.class)
    private Integer heroType;

}
