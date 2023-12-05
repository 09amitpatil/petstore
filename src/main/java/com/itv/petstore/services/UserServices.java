package com.itv.petstore.services;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.itv.petstore.dtos.RegistorUserDto;
import com.itv.petstore.entities.User;
@Service
public class UserServices {
    private Map<Integer, User> users = new HashMap<>();
    private AtomicInteger atomic = new AtomicInteger();
    
    
    public User registerUser(RegistorUserDto registorUserDto) {
        User user=new User();
        user.setId(atomic.incrementAndGet());
        user.setFirstname(registorUserDto.getFirstname());
        user.setLastname(registorUserDto.getLastname());
        user.setEmail(registorUserDto.getEmail());
        user.setPassword(registorUserDto.getPassword());
        user.setMobile(registorUserDto.getMobile());
        user.setSalary(registorUserDto.getSalary());
        users.put(user.getId(),user);
        return user;

    }
    
}
