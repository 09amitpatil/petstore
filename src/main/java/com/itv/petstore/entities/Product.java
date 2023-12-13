package com.itv.petstore.entities;

import lombok.Data;

@Data

public class Product {
    private Integer id;
    private String name;
    private String Manufature;
    private Double price;
    private String description;

}