package com.esgi.cleancode.server.mysql.driver.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static DbConnection jdbc;
    private static Connection connection;

    private DbConnection() {}

    public static DbConnection getInstance() {
        if (jdbc==null)
        {
            jdbc = new DbConnection();
        }
        return jdbc;
    }

    private static Connection initConnection()throws ClassNotFoundException, SQLException
    {
        String driverName = "com.mysql.jdbc.Driver";

        String serverName = "localhost:3306";
        String mydatabase = "cleancode";
        String url = "jdbc:mysql://" + serverName + "/" + mydatabase + "?characterEncoding=UTF-8&useSSL=false";
        String username = "dev";
        String password = "esgi";

        connection = DriverManager.getConnection(url, username, password);

        return connection;
    }

    public Connection getConnection() {
        if(connection == null){
            try {
                connection = initConnection();
            } catch (Exception e) {
                System.out.println("Unable to connect to database: " + e.getMessage());
                System.exit(1);
            }
        }
        return connection;
    }
}
