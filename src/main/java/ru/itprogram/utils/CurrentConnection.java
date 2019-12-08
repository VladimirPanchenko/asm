package ru.itprogram.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CurrentConnection {
    private final String DB_URL = "jdbc:postgresql://192.168.1.101:5432/asm";
    private final String USER = "asm";
    private final String PASSWORD = "password";
    private Connection connection;

    public CurrentConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}