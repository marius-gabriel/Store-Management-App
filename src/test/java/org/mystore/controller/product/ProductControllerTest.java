package org.mystore.controller.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mystore.dto.ProductDto;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @InjectMocks
    private ProductController controller;
    private static ProductDto testProduct;
    private static final String PRODUCT_NAME = "test product";
    private static final Long PRODUCT_PRICE = 1000L;

    @BeforeAll
    public static void getTestProduct(){
        testProduct = new ProductDto(PRODUCT_NAME, PRODUCT_PRICE);
    }

    @Test
    void testInsertProduct(){
        String insertedProductMessage = controller.insertProduct(testProduct);
        Assertions.assertEquals("Successfully inserted product: " + testProduct.toString(), insertedProductMessage);
    }
}