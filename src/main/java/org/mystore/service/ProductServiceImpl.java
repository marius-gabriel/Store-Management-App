package org.mystore.service;

import org.mystore.exceptions.ProductNotFoundException;
import org.mystore.model.Product;
import org.mystore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository){
        this.repository = repository;
    }

    @Override
    public Product insertProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Product getProductByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Product> getAllProducts(){
        return repository.findAll();
    }

    @Override
    public Product changePriceForProductWith(int id, int price) {
        Optional<Product> optionalProduct = repository.findById(id);
        Product currentProduct;
        if (optionalProduct.isPresent())
            currentProduct = optionalProduct.get();
        else throw new ProductNotFoundException("Unknown product with id: " + id);
        currentProduct.setPrinceInCents((long) price);
        return repository.save(currentProduct);
    }

    @Override
    public void deleteProduct(Product product) {
        repository.delete(product);
    }

    @Override
    public Product updateProductById(int id, Product modifiedProduct) {
        modifiedProduct.setId(id);
        return repository.save(modifiedProduct);
    }
}
