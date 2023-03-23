package dev.danvega.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

@RestController
@RequestMapping("~/api/scraper")
public class DatabaseController {

    @GetMapping("/TestConnection")
    public void TestConnection(){
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/myfavoritegroceries";
        String user = "root";
        String password = "";

        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database");
        } catch (SQLException ex) {
            System.out.println("An error occurred while connecting to the database");
            ex.printStackTrace();
        }

    }

    @GetMapping("/CreateNewProducts")
    public void InsertNewProducts(String ProductName, String ProductPrice, String StoreName){
        String url = "jdbc:mysql://localhost:3306/myfavoritegroceries";
        String user = "root";
        String password = "";

        try(Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO products (Name, Price, Store) VALUES (?, ?,?)")) {

            stmt.setString(1, ProductName);
            stmt.setString(2, ProductPrice);
            stmt.setString(3, StoreName);

            int rowsInserted = stmt.executeUpdate();
            System.out.println(rowsInserted + " row(s) inserted.");
        } catch (SQLException ex) {
            System.out.println("An error occurred while connecting to the database");
            ex.printStackTrace();
        }
    }
}
