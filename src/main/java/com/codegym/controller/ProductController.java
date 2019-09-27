package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.model.ProductForm;
import com.codegym.service.ProductService;
import com.codegym.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    //private ProductService productService = new ProductServiceImpl();


    @Autowired
    private ProductService productService;

    @RequestMapping("/list")
    public ModelAndView getAllProduct(){
        List<Product> productList = productService.findAll();

        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("products", productList);
        modelAndView.addObject("gender","F");
        modelAndView.addObject("message","Welcome CodeGym");

        return  modelAndView;

    }

    @GetMapping("/create")
    public ModelAndView createForm(){

        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("productForm", new ProductForm());

        return  modelAndView;

    }

    @PostMapping("/save-product")
    public ModelAndView saveProduct(@ModelAttribute ProductForm productForm, BindingResult result){


        // thong bao neu xay ra loi
        if (result.hasErrors()) {
            System.out.println("Result Error Occured" + result.getAllErrors());
        }

        productService.addUseProcedure(productForm);

        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product", new Product());

        return  modelAndView;

    }
}
