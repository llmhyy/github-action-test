package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class VulnerableApp {

    public void searchProducts() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name to search:");
        String productName = scanner.nextLine();

        String query = "SELECT * FROM products WHERE name = '" + productName + "'";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "user", "pass");
             Statement statement = connection.createStatement()) {

            // WARNING: This statement is vulnerable to SQL injection
            statement.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 

    public static void main(String[] args) {
        new VulnerableApp().searchProducts();
    }
}
