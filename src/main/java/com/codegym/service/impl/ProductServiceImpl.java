package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.model.ProductForm;
import com.codegym.repository.ProductRepository;
import com.codegym.repository.impl.ProductRepositoryImpl;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@PropertySource("classpath:general_config_app.properties")
public class ProductServiceImpl implements ProductService {

    //private ProductRepository productRepository = new ProductRepositoryImpl();

    @Autowired
    Environment env;

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

    @Override
    public void addUseProcedure(ProductForm productForm) {


        // lay ten file
        MultipartFile multipartFile = productForm.getImage();
        String fileName = multipartFile.getOriginalFilename();

        String fileUpload = env.getProperty("file_upload").toString();

        // luu file len server
        try {
            FileCopyUtils.copy(productForm.getImage().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        // tham khảo: https://github.com/codegym-vn/spring-static-resources

        // tao doi tuong de luu vao db
        Product productObject = new Product(productForm.getName(), productForm.getPrice(), fileName);

        // luu vao db
        //productService.save(productObject);
        //productService.add(productObject);

        productRepository.addUseProcedure(productObject);


        //productService.add(product);
    }


}
