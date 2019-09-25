package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    List<Product> productList = new ArrayList<>();
    {
        productList.add(new Product(1, "Samsung", 300.00,""));
        productList.add(new Product(2, "Iphone", 400.00,""));
        productList.add(new Product(3, "BlackBerry", 500.00,""));
        productList.add(new Product(4, "Nokia", 600.00,""));
        productList.add(new Product(5, "OPPO", 700.00,""));
    }


    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }
}
