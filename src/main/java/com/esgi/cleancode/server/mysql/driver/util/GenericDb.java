package com.esgi.cleancode.server.mysql.driver.util;



import com.esgi.cleancode.server.mysql.driver.annotation.DbColumnName;
import com.esgi.cleancode.server.mysql.driver.annotation.DbColumnType;
import com.esgi.cleancode.server.mysql.driver.annotation.DbTableName;
import javafx.util.Pair;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GenericDb {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private static String getFieldAnnotationKey(Field field) {
        String annotationValue = field.getAnnotation(DbColumnName.class).value();
        if (annotationValue.isEmpty()) {
            return field.getName();
        } else {
            return annotationValue;
        }
    }

    private String getClassAnnotationKey() {
        String annotationValue = this.getClass().getAnnotation(DbTableName.class).value();
        if (annotationValue.isEmpty()) {
            return this.getClass().getName();
        } else {
            return annotationValue;
        }
    }

    public String getObjectDbName() {
        return getClassAnnotationKey();
    }

    public List<javafx.util.Pair<String, String>> getObjectDbAttributes() throws IllegalAccessException {
        ArrayList<Pair<String, String>> result = new ArrayList<>();

        for (Field field : this.getClass().getDeclaredFields()) {
            String getterName = "get" + Character.toUpperCase(field.getName().charAt(0))
                    + field.getName().substring(1);
            try {
                Method getter = this.getClass().getDeclaredMethod(getterName);
                Object value = getter.invoke(this);

                Object finalValue;

                if (value != null) {
                    if (field.getAnnotation(DbColumnType.class).type() == String.class) {
                        finalValue = "'" + value + "'";
                    } else {
                        finalValue = value;
                    }
                } else {
                    finalValue = "NULL";
                }
                field.setAccessible(true);
                Pair<String, String> pair = new Pair(getFieldAnnotationKey(field), String.valueOf(finalValue));
                result.add(pair);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return result;
    }


}
