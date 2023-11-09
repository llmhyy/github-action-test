package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlInjectionExample {

    public void doLogin(String user, String pass) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test?" + "user=myuser&password=mypass");

            // Unsafe SQL query constructed by concatenating strings.
            String query = "SELECT * FROM users WHERE user = '" + user + "' AND password = '" + pass + "'";

            stmt = conn.createStatement();
            stmt.executeQuery(query);

            // ...

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } finally {
            // Finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
