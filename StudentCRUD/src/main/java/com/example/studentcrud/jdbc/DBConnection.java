package com.example.studentcrud.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.Properties;

public class DBConnection {
    public static Statement DBStatement() throws IOException {
        FileInputStream fis = new FileInputStream("src/main/resources/application.properties");
        Properties p = new Properties();
        p.load(fis);

        String url = (String) p.get("spring.datasource.url");
        String user = (String) p.get("spring.datasource.username");
        String password = (String) p.get("spring.datasource.password");

        Statement statement = null;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Pilote introuvable");
        }
        try {
            java.sql.Connection connection = DriverManager.getConnection(url, user, password);

            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }
}
