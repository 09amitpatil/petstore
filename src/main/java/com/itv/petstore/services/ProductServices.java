package com.itv.petstore.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itv.petstore.entites.Product;

@Service
public class ProductServices {
    private Map<Integer, Product> product = new HashMap<>();
    private AtomicInteger atomic = new AtomicInteger();
    private Object productServices;

    public ProductServices() {
        Product p = new Product();
        p.setId(atomic.incrementAndGet());
        p.setName("DEEP DEAR Extra Large Dog");
        p.setPrice(23223.67);
        p.setManufature("Thicker Pet Training and Puppy");
        p.setDescription("Thicker Pet Training and Puppy");
        product.put(p.getId(), p);

        Product p2 = new Product();
        p2.setId(atomic.incrementAndGet());
        p2.setName("DEEP DEAR Extra Large Dog");
        p2.setPrice(23223.67);
        p2.setManufature("Thicker Pet Training and Puppy");
        p2.setDescription("Thicker Pet Training and Puppy");
        product.put(p2.getId(), p2);
    }

    public Collection<Product> getAllProducts()

    {
        return product.values();
    }

    public Product getProductById(Integer id) {
        return product.get(id);
    }
}