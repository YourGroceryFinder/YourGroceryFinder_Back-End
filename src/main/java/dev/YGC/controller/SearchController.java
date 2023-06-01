package dev.YGC.controller;

import dev.YGC.Logic.Product;
import dev.YGC.Logic.ProductCollection;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("~/api/search")
@AllArgsConstructor
public class SearchController {

    ProductCollection productCollection;

    @GetMapping("/hello")
    public String hello(){
        return "Find your groceries";
    }

    @PostMapping("/GetProductsBySearch")
    public List<Product> GetProductsBySearch(@RequestBody String ProductName){
        String newProductString = ProductName.substring(0, ProductName.length() - 1);
        System.out.println(newProductString);

        List<Product> productList = productCollection.GetAllProductByName(newProductString);

        return productList;
    }

    @PostMapping("/GetAllProducts")
    public List<Product> GetAllProduct(@RequestBody String ProductName){
        return productCollection.GetAllProducts();
    }
}
