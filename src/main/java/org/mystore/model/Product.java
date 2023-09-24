package org.mystore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mystore.exceptions.ProductDescriptionException;

import java.io.Serializable;

@Entity
@Table(name="products")
public class Product implements Serializable {
    private static final Logger logger = LogManager.getLogger(Product.class);
    public static final String INCORRECT_PRODUCT_NAMING_MESSAGE = "Incorrect product naming";
    public static final String PRICE_CANNOT_BE_A_NEGATIVE_VALUE_MESSAGE = "Price cannot be a negative value";
    public static final String ID_CANNOT_BE_NEGATIVE = "id cannot be negative";
    public static final String CANNOT_SET_NEGATIVE_PRICE = "Cannot set negative price";
    public static final String CANNOT_SET_NEGATIVE_ID = "Cannot set negative id";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Long princeInCents;

    public String getName(){
        return this.name;
    }

    public Long getPrinceInCents(){
        return this.princeInCents;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if (id >= 0)
            this.id = id;
        else failWithIdException();
    }

    public void setName(String name) {
        if (name != null && !name.isBlank())
            this.name = name;
        else failWithNamingException();
    }

    public void setPrinceInCents(Long princeInCents) {
        if (princeInCents >= 0 )
            this.princeInCents = princeInCents;
        else failWithPriceException();
    }

    public Product(){}

    public Product(int id, String name, Long princeInCents) {
        this(name, princeInCents);
        if (id >= 0)
            this.id = id;
        else failWithIdException();
    }

    public Product(String name, Long princeInCents){
        if (name != null && !name.isBlank())
            this.name = name;
        else failWithNamingException();
        if (princeInCents >= 0 )
            this.princeInCents = princeInCents;
        else failWithPriceException();
    }

    private static void failWithPriceException() {
        logger.error(CANNOT_SET_NEGATIVE_PRICE);
        throw new ProductDescriptionException(PRICE_CANNOT_BE_A_NEGATIVE_VALUE_MESSAGE);
    }

    private static void failWithIdException() {
        logger.error(CANNOT_SET_NEGATIVE_ID);
        throw new ProductDescriptionException(ID_CANNOT_BE_NEGATIVE);
    }

    private static void failWithNamingException() {
        logger.error("Cannot set null or empty product name");
        throw new ProductDescriptionException(INCORRECT_PRODUCT_NAMING_MESSAGE);
    }

    @Override
    public String toString() {
        return "Product{ id=" + id +
                ", name='" + name + '\'' +
                ", princeInCents=" + princeInCents +
                '}';
    }
}
