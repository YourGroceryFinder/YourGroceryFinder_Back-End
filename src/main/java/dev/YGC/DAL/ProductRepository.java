package dev.YGC.DAL;

import dev.YGC.Logic.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN TRUE ELSE FALSE END FROM product p WHERE p.Name = ?1")
    boolean selectExistsName(String productName);

    @Query(
        value = "SELECT * FROM product p WHERE p.Name LIKE :productName",
        nativeQuery = true)
    List<Product> GetAllProductByName(@Param("productName")String ProductName);
}
