package org.mystore.service;

import org.mystore.dto.ProductDto;

public interface ProductService {
    void insertProduct(ProductDto productDto);
    ProductDto getProductByName(String name);
    void deleteProduct(ProductDto productDto);
    void updateProductByName(String name, ProductDto modifiedProduct);
}
