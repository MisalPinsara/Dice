package com.app.classes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseOperator {

    private static final String URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=dice_database;"
            + "user=sa;"
            + "password=Misal@sqlserver0228;"
            + "encrypt=true;"
            + "trustServerCertificate=true;";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public int runUpdate(String query, Object[] params) {
        int result = 0;
        try (Connection conn = getConnection();
                PreparedStatement pst = conn.prepareStatement(query)) {

            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pst.setObject(i + 1, params[i]);
                }
            }
            result = pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<List<Object>> runSelect(String query, Object[] params) {
        List<List<Object>> results = new ArrayList<>();

        try (Connection conn = getConnection();
                PreparedStatement pst = conn.prepareStatement(query)) {

            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pst.setObject(i + 1, params[i]);
                }
            }

            try (ResultSet rs = pst.executeQuery()) {
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();

                while (rs.next()) {
                    List<Object> row = new ArrayList<>();
                    for (int i = 1; i <= columnCount; i++) {
                        row.add(rs.getObject(i));
                    }
                    results.add(row);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }
}
