package com.itv.petstore.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itv.petstore.entites.Product;
import com.itv.petstore.services.ProductServices;

@RestController
public class productcontroller {
    @RequestMapping("/")
    public String getName() {
        return "My Name is Amit";
    }

    @RequestMapping("/score")
    public int getscore() {
        return 99;
    }

    @Autowired
    private ProductServices productServices;

    @RequestMapping("/products")
    public Collection<Product> getProducts() {
        return this.productServices.getAllProducts();
    }

    @RequestMapping("/products/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return this.productServices.getProductById(id);
    }
}