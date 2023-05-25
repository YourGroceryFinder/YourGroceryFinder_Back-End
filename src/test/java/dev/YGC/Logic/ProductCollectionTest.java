package dev.YGC.Logic;

import dev.YGC.DAL.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)

class ProductCollectionTest {

    @Mock
    private ProductRepository productRepository;
    private ProductCollection underTest;

    @BeforeEach
    void setUp() {
        underTest = new ProductCollection(productRepository);
    }

    @Test
    void canGetAllProductByName() {
        //When
        underTest.GetAllProductByName("Komkommer");
        //Then
        verify(productRepository).GetAllProductByName("Komkommer");
    }
}