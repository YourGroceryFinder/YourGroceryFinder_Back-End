package dev.YGC.controller;
import dev.YGC.classes.Product;

import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;


@RestController
@RequestMapping("~/api/scraper")
public class DatabaseController {

    String url = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7614383";
    String user = "sql7614383";
    String password = "MXyKdG96dR";

    @GetMapping("/TestConnection")
    public void TestConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database");
        } catch (SQLException ex) {
            System.out.println("An error occurred while connecting to the database");
            ex.printStackTrace();
        }

    }

    @PostMapping ("/GetProducts")
    public ArrayList<Product> GetProductsRequested(@RequestBody String ProductName){
        ArrayList<Product> Products = new ArrayList<Product>();

        String notweird = ProductName.substring(0,ProductName.length() - 1);

        try(Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM products WHERE Name LIKE ?")) {
            stmt.setString(1, "%"+notweird+"%");

            ResultSet result = stmt.executeQuery();
            while(result.next()){
                Products.add(new Product(result.getString("Name"), result.getString("imglink"),result.getString("Price"),result.getString("Store")));
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred while connecting to the database");
            ex.printStackTrace();
        }

        return Products;
    }
}
