package org.mystore.Exceptions;

public class ProductDescriptionException extends RuntimeException{
    String message;

    public ProductDescriptionException(String message){
        super(message);
    }
}
