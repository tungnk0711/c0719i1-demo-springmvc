package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class ProductForm {

    private int id;
    private String name;
    private Double price;
    private MultipartFile image;

    public ProductForm() {
    }

    public ProductForm(int id, String name, Double price, MultipartFile image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}

