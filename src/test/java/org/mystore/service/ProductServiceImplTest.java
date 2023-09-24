package org.mystore.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mystore.exceptions.ProductNotFoundException;
import org.mystore.model.Product;
import org.mystore.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductServiceImpl productService;
    private static Product testProduct;
    private static final String PRODUCT_NAME = "test product";
    private static final Long PRODUCT_PRICE = 1000L;

    @BeforeEach
    public void getTestProduct(){
        testProduct = new Product(PRODUCT_NAME, PRODUCT_PRICE);
        productService = new ProductServiceImpl(productRepository);
    }

    @Test
    void testInsertProduct(){
        when(productRepository.save(testProduct)).thenReturn(new Product(PRODUCT_NAME, PRODUCT_PRICE));
        Product insertedProduct = productService.insertProduct(testProduct);
        Assertions.assertEquals(testProduct.getName(), insertedProduct.getName());
        Assertions.assertEquals(testProduct.getPrinceInCents(), insertedProduct.getPrinceInCents());
    }

    @Test
    void testGetProductByName(){
        when(productRepository.findByName(PRODUCT_NAME)).thenReturn(new Product(PRODUCT_NAME, PRODUCT_PRICE));
        Product serchedProduct = productService.getProductByName(PRODUCT_NAME);
        Assertions.assertEquals(testProduct.getName(), serchedProduct.getName());
        Assertions.assertEquals(testProduct.getPrinceInCents(), serchedProduct.getPrinceInCents());
    }

    @Test
    void testGetAllProducts(){
        List<Product> testProductList = List.of(new Product(PRODUCT_NAME, PRODUCT_PRICE));
        when(productRepository.findAll()).thenReturn(testProductList);
        List<Product> allProducts = productService.getAllProducts();
        Assertions.assertEquals(testProductList.size(), allProducts.size());
        Assertions.assertEquals(testProductList, allProducts);
    }

    @Test
    void testDeleteProduct(){
        Product testProduct = new Product(1, PRODUCT_NAME, PRODUCT_PRICE);
        productService.deleteProduct(testProduct);
        InOrder inOrder = Mockito.inOrder( productRepository);
        inOrder.verify(productRepository, times(1)).delete(testProduct);
    }

    @Test
    void testUpdateProduct(){
        int id = 2;
        Product testProduct = new Product(PRODUCT_NAME, PRODUCT_PRICE);
        Product testProductWithId = new Product(id, PRODUCT_NAME, PRODUCT_PRICE);
        when(productRepository.save(testProduct)).thenReturn(testProductWithId);
        Product result = productService.updateProductById(id, testProduct);
        Assertions.assertEquals(testProductWithId, result);
    }

    @Test
    void testChangeProductPriceThrowException(){
        int id = 6;
        int price = 400;
        when(productRepository.findById(id)).thenReturn(Optional.empty());
        Assertions.assertThrows(ProductNotFoundException.class, () -> productService.changePriceForProductWith(id, price));
    }

    @Test
    void testChangeProductPrice(){
        int id = 6;
        int price = 400;
        Product testProduct = new Product(id, "test", PRODUCT_PRICE);
        Product resultedProduct = new Product(id, "test", (long) price);
        when(productRepository.findById(id)).thenReturn(Optional.of(testProduct));
        when(productRepository.save(testProduct)).thenReturn(resultedProduct);
        Assertions.assertDoesNotThrow(() -> productService.changePriceForProductWith(id, price));
        Assertions.assertEquals(resultedProduct, productService.changePriceForProductWith(id, price));
    }

}