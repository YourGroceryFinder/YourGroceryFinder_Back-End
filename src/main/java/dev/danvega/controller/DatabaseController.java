package dev.danvega.controller;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;

import dev.danvega.controller.Product;

@RestController
@RequestMapping("~/api/scraper")
public class DatabaseController {

    String url = "jdbc:mysql://studmysql01.fhict.local:3306/dbi494690";
    String user = "dbi494690";
    String password = "Lolypop0987.";

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

    @GetMapping("/CreateNewProducts")
    public void InsertNewProducts(String ProductName, String image, String ProductPrice, String StoreName){
        try(Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO products (Name, imgLink, Price, Store) VALUES (?,?,?,?)")) {

            stmt.setString(1, ProductName);
            stmt.setString(2, image);
            stmt.setString(3, ProductPrice);
            stmt.setString(4, StoreName);

            int rowsInserted = stmt.executeUpdate();
            System.out.println(rowsInserted + " row(s) inserted.");
        } catch (SQLException ex) {
            System.out.println("An error occurred while connecting to the database");
            ex.printStackTrace();
        }


    }

    @PostMapping ("/GetProducts")
    public ArrayList<Product> GetProductsRequested(@RequestBody String ProductName){
        ArrayList<String> products = new ArrayList<String>();

        ArrayList<Product> Products = new ArrayList<Product>();

        String notweird = ProductName.substring(0,ProductName.length() - 1);

        try(Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM products WHERE Name LIKE ?")) {
            stmt.setString(1, "%"+notweird+"%");

            ResultSet result = stmt.executeQuery();
            while(result.next()){
                Products.add(new Product(result.getString("Name"), result.getString("imglink"),result.getString("Price"),result.getString("Store")));

                String lastName = result.getString("Name");
                products.add(lastName);
                System.out.println(lastName);
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred while connecting to the database");
            ex.printStackTrace();
        }

        return Products;
    }
}
