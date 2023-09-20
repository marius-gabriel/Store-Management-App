package org.mystore.service;

import org.mystore.model.Product;

import java.util.List;

public interface ProductService {
    Product insertProduct(Product product);
    Product getProductByName(String name);
    void deleteProduct(Product product);
    Product updateProductById(int id, Product modifiedProduct);
    List<Product> getAllProducts();
    Product changePriceForProductWith(int id, int price);
}
