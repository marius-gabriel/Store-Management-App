package org.mystore.repository;

import org.mystore.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    Product findByName(String name);
    List<Product> findAll();
}
