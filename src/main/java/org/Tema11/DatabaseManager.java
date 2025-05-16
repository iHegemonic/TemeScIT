package org.Tema11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
private Connection conn;

public void connect() {
    try {
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "x23");
        System.out.println("Connected to the database.");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public void disconnect() {
        try {
            if (conn != null) conn.close();
            System.out.println("Successfully disconnected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }

}
