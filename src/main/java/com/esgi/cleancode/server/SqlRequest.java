package com.esgi.cleancode.server;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

public class SqlRequest {
    protected DbConnection jdbc = DbConnection.getInstance();

    HashMap<String, Object> args = new HashMap<>();

    public SqlRequest addArgs(String name, Object value) {
        args.put(name, String.valueOf(value));
        return this;
    }

    public List<HashMap<String, Object>> execute() {
        Connection connection = jdbc.getConnection();

        try {
            String sql = "SELECT * FROM company;";

            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);

            if(rs.next()) {

                ResultSetMetaData rsMetaData = rs.getMetaData();
                int count = rsMetaData.getColumnCount();
                for (int i = 1; i <= count; i++) {
                    rsMetaData.getColumnName(i);
                    rs.getString(i);
                }
            }
        } catch (Exception e) {
            System.exit(1);
            return null;
        }
        return null;
    }

}
