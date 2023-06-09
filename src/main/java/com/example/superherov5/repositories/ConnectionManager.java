package com.example.superherov5.repositories;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

    private static String url;
    private static String user;
    private static String pwd;
    private static Connection con;


    public static Connection getConnection() {
        if (con != null){
            return con;
        }
        try (InputStream input = new FileInputStream("src/main/resources/application.properties")) {
            Properties properties = new Properties();
            properties.load(input);
            url = properties.getProperty("spring.datasource.url");
            user = properties.getProperty("spring.datasource.username");
            pwd = properties.getProperty("spring.datasource.password");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

}
