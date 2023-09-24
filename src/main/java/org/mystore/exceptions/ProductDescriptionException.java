package org.mystore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ProductDescriptionException extends RuntimeException{
    public ProductDescriptionException(String message){
        super(message);
    }
}
