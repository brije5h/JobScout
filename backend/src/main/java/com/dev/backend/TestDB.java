package com.dev.backend;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDB {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5431/jobdb";
        String user = "admin";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
