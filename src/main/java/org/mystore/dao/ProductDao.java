package org.mystore.dao;

import org.mystore.Exceptions.ProductDescriptionException;
public class ProductDao {
    public static final String INCORRECT_PRODUCT_NAMING_MESSAGE = "Incorrect product naming";
    public static final String PRICE_CANNOT_BE_A_NEGATIVE_VALUE_MESSAGE = "Price cannot be a negative value";
    private String name;
    private Long princeInCents;

    public String getName(){
        return this.name;
    }

    public Long getPrinceInCents(){
        return this.princeInCents;
    }

    public ProductDao(String name, Long princeInCents){
        if (name != null && !name.isBlank())
            this.name = name;
        else throw new ProductDescriptionException(INCORRECT_PRODUCT_NAMING_MESSAGE);
        if (princeInCents >= 0 )
            this.princeInCents = princeInCents;
        else throw new ProductDescriptionException(PRICE_CANNOT_BE_A_NEGATIVE_VALUE_MESSAGE);
    }

    @Override
    public String toString() {
        return "Product {" +
                "name='" + name + '\'' +
                ", princeInCents=" + princeInCents +
                '}';
    }
}
