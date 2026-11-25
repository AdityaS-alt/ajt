package edu.dypatil.ajt.exp04.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DbConfig {
    private static final String DEFAULT_URL =
            "jdbc:mysql://localhost:3306/ajt_lab?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException exception) {
            throw new ExceptionInInitializerError(exception);
        }
    }

    private DbConfig() {
    }

    public static Connection openConnection() throws SQLException {
        String url = read("AJT_DB_URL", DEFAULT_URL);
        String user = read("AJT_DB_USER", "root");
        String password = read("AJT_DB_PASSWORD", "");
        return DriverManager.getConnection(url, user, password);
    }

    private static String read(String name, String defaultValue) {
        String value = System.getenv(name);
        return value == null || value.isBlank() ? defaultValue : value;
    }
}

