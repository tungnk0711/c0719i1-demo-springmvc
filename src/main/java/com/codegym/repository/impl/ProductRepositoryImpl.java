package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Transactional
public class ProductRepositoryImpl implements ProductRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Product> findAll() {

        /*TypedQuery<Product> query = em.createQuery("select p from Product p where id like :pid", Product.class);
        query.setParameter("pid",Long.valueOf("2"));
        return query.getResultList();*/

        List<Product> productList = em.createNamedQuery("findAllProducts").getResultList();
        return productList;
    }

    @Override
    public void add(Product product) {
        if (product.getId() != null) {
            em.merge(product);
        } else {
            em.persist(product);
        }
    }

    @Override
    public void addUseProcedure(Product product) {

        StoredProcedureQuery spAddProduct = em.createNamedStoredProcedureQuery("addProduct");
        spAddProduct.setParameter("image", product.getImage());
        spAddProduct.setParameter("name", product.getName());
        spAddProduct.setParameter("price", product.getPrice());
        spAddProduct.execute();
    }
}
