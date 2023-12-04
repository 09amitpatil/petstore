package com.itv.petstore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itv.petstore.dtos.RegistorUserDto;
import com.itv.petstore.entities.User;
import com.itv.petstore.services.UserServices;

import jakarta.validation.Valid;
@RestController
public class UserController {
    @Autowired 
    private UserServices userServices;

    @PostMapping("/users")
    public User registerUser(@RequestBody @Valid RegistorUserDto registorUserDto)
    {
        return this.userServices.registerUser(registorUserDto);
    }
    
}
