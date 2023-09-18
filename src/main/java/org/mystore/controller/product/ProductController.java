package org.mystore.controller.product;

import org.mystore.dto.ProductDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private static final String PATH = "/product";

    @PostMapping(value = PATH)
    public String insertProduct(ProductDto product){
        return "null";
    }
}
