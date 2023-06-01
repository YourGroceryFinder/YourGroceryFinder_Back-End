package dev.YGC.Logic;

import dev.YGC.DAL.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductCollection {

    ProductRepository productRepository;

    public boolean selectExistsName(String productName){
        return productRepository.selectExistsName(productName);
    }

    public List<Product> GetAllProductByName(String ProductName){
        List<Product> productList = this.productRepository.GetAllProductByName(ProductName);
        return productList;
    }

    public List<Product> GetAllProducts(){
        return this.productRepository.findAll();
    }
}
