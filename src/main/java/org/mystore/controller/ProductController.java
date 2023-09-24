package org.mystore.controller;

import org.mystore.model.Product;
import org.mystore.service.ProductService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class ProductController {

    private final ProductService productService;
    private static final String PATH = "/product";

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping(PATH)
    public Product insertProduct(@RequestBody Product product){
        return productService.insertProduct(product);
    }

    @DeleteMapping(PATH)
    public void deleteProduct(@RequestBody Product product){
        productService.deleteProduct(product);
    }

    @PutMapping(PATH)
    public Product updateProductById(@RequestParam(value = "id") int id, @RequestBody Product product){
        return productService.updateProductById(id, product);
    }

    @GetMapping(value = PATH +"/{name}")
    public Product getProductByName(@PathVariable("name") String name){
        return productService.getProductByName(name);
    }

    @GetMapping(PATH)
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PatchMapping(PATH)
    public Product changePrice(@RequestParam(value = "id") int id, @RequestParam(value = "newPrice") Integer newPrice){
        return productService.changePriceForProductWith(id, newPrice);
    }

}
