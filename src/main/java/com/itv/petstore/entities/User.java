package com.itv.petstore.entities;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class User {
    private Integer id;
    @NotNull@NotEmpty
    private String firstname;
     @NotNull@NotEmpty
    private String lastname;
     @NotNull@NotEmpty
    private String email;
     @NotNull@NotEmpty
    private String password;
     @NotNull@NotEmpty
    private String mobile;
    
    private long salary;

    
}
