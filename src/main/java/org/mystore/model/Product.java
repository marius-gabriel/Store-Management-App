package org.mystore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.mystore.exceptions.ProductDescriptionException;

import java.io.Serializable;

@Entity
@Table(name="products")
public class Product implements Serializable {
    public static final String INCORRECT_PRODUCT_NAMING_MESSAGE = "Incorrect product naming";
    public static final String PRICE_CANNOT_BE_A_NEGATIVE_VALUE_MESSAGE = "Price cannot be a negative value";
    public static final String ID_CANNOT_BE_NEGATIVE = "id cannot be negative";

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
        else throw new ProductDescriptionException(ID_CANNOT_BE_NEGATIVE);
    }

    public void setName(String name) {
        if (name != null && !name.isBlank())
            this.name = name;
        else throw new ProductDescriptionException(INCORRECT_PRODUCT_NAMING_MESSAGE);
    }

    public void setPrinceInCents(Long princeInCents) {
        if (princeInCents >= 0 )
            this.princeInCents = princeInCents;
        else throw new ProductDescriptionException(PRICE_CANNOT_BE_A_NEGATIVE_VALUE_MESSAGE);
    }

    public Product(){}

    public Product(int id, String name, Long princeInCents) {
        this(name, princeInCents);
        if (id >= 0)
            this.id = id;
        else throw new ProductDescriptionException(ID_CANNOT_BE_NEGATIVE);
    }

    public Product(String name, Long princeInCents){
        if (name != null && !name.isBlank())
            this.name = name;
        else throw new ProductDescriptionException(INCORRECT_PRODUCT_NAMING_MESSAGE);
        if (princeInCents >= 0 )
            this.princeInCents = princeInCents;
        else throw new ProductDescriptionException(PRICE_CANNOT_BE_A_NEGATIVE_VALUE_MESSAGE);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", princeInCents=" + princeInCents +
                '}';
    }
}
