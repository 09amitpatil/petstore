package com.itv.petstore.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itv.petstore.entities.Product;
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

    //@RequestMapping(path="/products",method=RequestMethod.GET)
    @GetMapping("/products")
    public Collection<Product> getProducts() 
    {
        return this.productServices.getAllProducts();
    }

    //@RequestMapping(path="/products/{id}",method = RequestMethod.GET)
        @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Integer id) 
    {
        return this.productServices.getProductById(id);
    }

     //@RequestMapping(path="/products",method=RequestMethod.POST)
     @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) 
    {
        return this.productServices.addProduct(product);
    }

    //@RequestMapping(path="/products/{id}",method = RequestMethod.DELETE)
    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable Integer id) 
    {
        return this.productServices.deleteProduct(id);
    }

    
    //@RequestMapping(path="/products/{id}",method=RequestMethod.PUT)
    @PutMapping("/products/{id}")
    public String updateProduct(@PathVariable Integer id ,@RequestBody Product product)
    {
        return this.productServices.updateProduct(id,product);
    }
}