package com.esgi.cleancode.server.driver.generic;

import com.esgi.cleancode.server.DbConnection;
import com.esgi.cleancode.server.driver.annotation.DbColumnName;
import com.esgi.cleancode.server.driver.annotation.DbColumnType;
import javafx.util.Pair;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenericDao {

    protected DbConnection jdbc = DbConnection.getInstance();

    private String prepareInsertRequest(String className, List<Pair<String, String>> params) {
        StringBuilder request = new StringBuilder();
        request.append("INSERT INTO ").append(className).append("(");

        StringBuilder valuesName = new StringBuilder();
        StringBuilder values = new StringBuilder();

        for (Pair<String, String> param : params) {
            if (valuesName.length() > 0) {
                valuesName.append(", ").append(param.getKey());
                values.append(", ").append(param.getValue());
            } else {
                valuesName.append(param.getKey());
                values.append(param.getValue());
            }
        }
        System.out.println(request.append(valuesName).append(") VALUES (").append(values).append(");"));
        return request.toString();
    }

    public int insert(GenericDb object) throws SQLException {
        int recordCounter = 0;
        PreparedStatement ps = null;
        Connection connection = jdbc.getConnection();

        if (object.getId() == null) {
            object.setId(getLastId(object.getObjectDbName()) + 1);
        }

        try {
            ps = connection.prepareStatement(prepareInsertRequest(object.getObjectDbName(), object.getObjectDbAttributes()));
            recordCounter = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recordCounter;
    }

    private String prepareUpdateRequest(String className, List<Pair<String, String>> params) {
        StringBuilder request = new StringBuilder();
        request.append("UPDATE ").append(className).append(" SET ");

        StringBuilder valuesName = new StringBuilder();

        for (Pair<String, String> param : params) {
            if (valuesName.length() > 0) {
                valuesName.append(", ").append(param.getKey()).append(" = ").append(param.getValue());

            } else {
                valuesName.append(param.getKey()).append(" = ").append(param.getValue());
            }
        }
        System.out.println(request.append(valuesName).append(" WHERE id=").append(params.get(0).getValue()));
        return request.toString();
    }

    public int update(GenericDb object) throws SQLException {
        int recordCounter = 0;
        PreparedStatement ps = null;
        Connection connection = jdbc.getConnection();

        try {
            ps = connection.prepareStatement(prepareUpdateRequest(object.getObjectDbName(), object.getObjectDbAttributes()));
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recordCounter;
    }

    private String prepareDeleteRequest(String className, List<Pair<String, String>> params) {
        StringBuilder request = new StringBuilder();
        request.append("DELETE FROM ").append(className).append(" WHERE id= ").append(params.get(0).getValue());
        return request.toString();
    }

    public int delete(GenericDb object) throws SQLException {
        int recordCounter = 0;
        PreparedStatement ps = null;
        Connection connection = jdbc.getConnection();

        try {
            ps = connection.prepareStatement(prepareDeleteRequest(object.getObjectDbName(), object.getObjectDbAttributes()));
            recordCounter = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recordCounter;
    }

    public Integer getLastId(String className) throws SQLException {
        Connection connection = jdbc.getConnection();
        try {
            String sql = "SELECT MAX(id) FROM " + className + ";";

            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (Exception e) {
            System.out.println("An error has occured while retrieving last id for table: " + className);
            System.exit(1);
            return null;
        }
    }

    public void startDbTransaction() {
        Connection connection = jdbc.getConnection();

        String sql = "START TRANSACTION;";
        try {
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);
        } catch (Exception e) {

        }

    }

    public void rollbackDbTransaction() throws SQLException {
        Connection connection = jdbc.getConnection();
        String sql = "ROLLBACK;";

        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(sql);
    }

    public <T extends GenericDb> T get(String sql, Class<T> dbClass) {
        Connection connection = jdbc.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(sql);
            Object object = Class.forName(dbClass.getName()).getConstructor().newInstance();
            while (results.next()) {
                for (Field field : dbClass.getDeclaredFields()) {
                    Class<?> type = field.getAnnotation(DbColumnType.class).type();
                    String dbFieldName = field.getAnnotation(DbColumnName.class).value();

                    String setterName = "set" + Character.toUpperCase(field.getName().charAt(0))
                            + field.getName().substring(1);
                    Method setter = dbClass.getDeclaredMethod(setterName, field.getType());

                    if (type.equals(String.class)) {
                        setter.invoke(object, results.getString(field.getAnnotation(DbColumnName.class).value()));
                    } else if (type.equals(Boolean.class)) {
                        setter.invoke(object, results.getBoolean(field.getAnnotation(DbColumnName.class).value()));
                    } else if (type.equals(Integer.class)) {
                        setter.invoke(object, results.getInt(field.getAnnotation(DbColumnName.class).value()));
                    } else if (type.equals(Date.class)) {
                        setter.invoke(object, results.getDate(field.getAnnotation(DbColumnName.class).value()));
                    } else {
                        setter.invoke(object, results.getLong(field.getAnnotation(DbColumnName.class).value()));
                    }
                }
            }
            return dbClass.cast(object);
        } catch (Exception e) {
            System.out.println("Une erreur est survenue");
            return null;
        }
    }

    public <T extends GenericDb> List<T> getList(String sql, Class<T> dbClass) {
        Connection connection = jdbc.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(sql);
            List<T> objects = new ArrayList<>();
            while (results.next()) {
                Object object = Class.forName(dbClass.getName()).getConstructor().newInstance();
                for (Field field : dbClass.getDeclaredFields()) {
                    Class<?> type = field.getAnnotation(DbColumnType.class).type();
                    String dbFieldName = field.getAnnotation(DbColumnName.class).value();

                    String setterName = "set" + Character.toUpperCase(field.getName().charAt(0))
                            + field.getName().substring(1);
                    Method setter = dbClass.getDeclaredMethod(setterName, field.getType());

                    if (type.equals(String.class)) {
                        setter.invoke(object, results.getString(field.getAnnotation(DbColumnName.class).value()));
                    } else if (type.equals(Boolean.class)) {
                        setter.invoke(object, results.getBoolean(field.getAnnotation(DbColumnName.class).value()));
                    } else if (type.equals(Integer.class)) {
                        setter.invoke(object, results.getInt(field.getAnnotation(DbColumnName.class).value()));
                    } else if (type.equals(Date.class)) {
                        setter.invoke(object, results.getDate(field.getAnnotation(DbColumnName.class).value()));
                    } else {
                        setter.invoke(object, results.getLong(field.getAnnotation(DbColumnName.class).value()));
                    }
                }
                objects.add(dbClass.cast(object));
            }
            return objects;
        } catch (Exception e) {
            System.out.println("Une erreur est survenue");
            return null;
        }
    }

}
