package dev.YGC.DAL;

import dev.YGC.Logic.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldCheckWhenProductExistsByName() {
        //Given
        String name = "Komkommer";

        Product product = new Product(
                name,
                "https://static.ah.nl/dam/product/AHI_43545239393130333237?revLabel=1&rendition=800x800_JPG_Q90&fileType=binary",
                15.0,
                "AH"
        );
        underTest.save(product);
        //When
        boolean exists = underTest.selectExistsName(name);

        //Then
        assertThat(exists).isTrue();
    }

    @Test
    void itShouldCheckIfProductNotExistsByName() {
        //Given
        String name = "Komkommer";

        //When
        boolean exists = underTest.selectExistsName(name);

        //Then
        assertThat(exists).isFalse();
    }

    @Test
    void itShouldCheckIfGetProducts(){
        //Given
        String name = "Komkommer";

        Product product = new Product(
                name,
                "https://static.ah.nl/dam/product/AHI_43545239393130333237?revLabel=1&rendition=800x800_JPG_Q90&fileType=binary",
                15.0,
                "AH"
        );
        underTest.save(product);

        //When
        List<Product> productList = this.underTest.GetAllProductByName(name);

        //Then
        assertThat(productList.get(0)).isEqualTo(product);
    }
}