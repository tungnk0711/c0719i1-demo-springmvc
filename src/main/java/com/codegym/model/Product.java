package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
@NamedQuery(
        name = "findAllProducts",
        query = "SELECT p FROM Product p")
@NamedStoredProcedureQuery(
        name = "addProduct",
        procedureName = "sp_insert_product",
        parameters = {
                @StoredProcedureParameter(name = "image", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "name", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "price", mode = ParameterMode.IN, type = Double.class)
        }
)
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;
    private Double price;
    private String image;

    public Product() {
    }

    public Product(String name, Double price, String image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public Product(Long id, String name, Double price, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
