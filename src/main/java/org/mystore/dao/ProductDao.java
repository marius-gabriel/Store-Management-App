package org.mystore.dao;

import org.mystore.dto.ProductDto;

public class ProductDao {
    private Integer id;
    private ProductDto productDto;

    public Integer getId() {
        return id;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public ProductDao(Integer id, String name, Long priceInCents) {
        this.id = id;
        this.productDto = new ProductDto(name, priceInCents);
    }
}
