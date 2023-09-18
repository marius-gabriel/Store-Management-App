package org.mystore.controller.product;

import org.mystore.dto.ProductDto;
import org.mystore.service.ProductService;
import org.mystore.service.product.ProductServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductService productService;
    private static final String PATH = "/product";

    public ProductController(ProductService productService){
        this.productService = new ProductServiceImpl();
    }

    @PostMapping(value = PATH)
    public String insertProduct(ProductDto product){
        return "null";
    }
}
