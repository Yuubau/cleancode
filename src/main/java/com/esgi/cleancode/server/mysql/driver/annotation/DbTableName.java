package com.esgi.cleancode.server.mysql.driver.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface DbTableName {
    public String value();
}
