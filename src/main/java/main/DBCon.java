package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {
//    database connection
    public Connection getConnectionBD() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/nagii_union?useUnicode=true&serverTimezone=UTC",
                    "root",
                    "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
