package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;
import com.codegym.repository.impl.ProductRepositoryImpl;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    //private ProductRepository productRepository = new ProductRepositoryImpl();

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List findAll() {
        return productRepository.findAll();
    }

    @Override
    public void add(Product product) {
        productRepository.add(product);
    }
}
