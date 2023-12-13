package com.itv.petstore.dtos;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.itv.petstore.validators.VerifyPassword.VerifyPasswod;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@VerifyPasswod(Filed = "password", matchingFiled = "confirmpassword")
public class RegistorPetDto {
    private Integer id;
    @Size(min = 3,max = 10,message = "pname name length should have min 3 max 10 char")
    @NotNull@NotEmpty
    private String pname;
    @NotNull@NotEmpty
    private String ptype;
    
    @NotNull@NotEmpty
    private String password;
    @NotNull@NotEmpty
    private String confirmpassword;
    @NotNull@NotEmpty
    
    @com.itv.petstore.validators.mobile
    private String  mobile;
    
    @CreatedDate
    private Instant CreatedAt;
    @LastModifiedDate
    private Instant ModifiedAt;
}
