package com.itv.petstore.dtos;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.itv.petstore.validators.VerifyPassword.VerifyPasswod;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@VerifyPasswod(Filed = "password", matchingFiled = "confirmpassword")
public class RegistorUserDto {
    private Integer id;
    @Size(min = 4,max = 10,message = "First name length should have min 4 max 10 char")
    @NotNull@NotEmpty
    private String firstname;
    @NotNull@NotEmpty
    private String lastname;
    @NotNull@NotEmpty
    private String email;
    @NotNull@NotEmpty
    private String password;
    @NotNull@NotEmpty
    private String confirmpassword;
    @NotNull@NotEmpty
    
    @com.itv.petstore.validators.mobile
    private String  mobile;
    
    @Min(value = 10000 ,message = "minimum salary should be 10000")
    @Max(value = 100000,message = "minimum salary should be 100000") 
    private long salary;
    @CreatedDate
    private Instant CreatedAt;
    @LastModifiedDate
    private Instant ModifiedAt;
}
