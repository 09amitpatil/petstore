package com.itv.petstore.Controller;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
//adding data
    @PostMapping("/users")
    public ResponseEntity<?> registerUser(@RequestBody  @Valid RegistorUserDto registerUserDto)
    {
        return  new  ResponseEntity<>(this.userServices.registerUser(registerUserDto),HttpStatus.CREATED);
    }
    //retriving data
    @GetMapping("/users")
   public ResponseEntity<?>getAll()
   {
    return ResponseEntity.ok(this.userServices.getAll());
   }
  //searching data
  @GetMapping("/users/{id}")
public ResponseEntity<?>getById(@PathVariable Integer id)
   {
    User userExits=this.userServices.getById(id);
    if(userExits!=null)
    {
        return new ResponseEntity<>(userExits,HttpStatus.OK);
    }
    else{
        return new ResponseEntity<>("user not found",HttpStatus.NOT_FOUND);
    }
   }
    @DeleteMapping("/users/{id}")
   public ResponseEntity<?>deleteuser(@PathVariable Integer id)
   {
    User userExits=this.userServices.getById(id);
    if(userExits!=null)
    {
        this.userServices.deleteuser(id);
        return new ResponseEntity<>("user deleted sucessfully",HttpStatus.OK);
    }
    else{
        return new ResponseEntity<>("user not found",HttpStatus.NOT_FOUND);
    }
   }
   @PutMapping("/users/{id}")
   public ResponseEntity<?>updateuser(@PathVariable Integer id)
   {
    User userExits=this.userServices.getById(id);
    if(userExits!=null)
    {
        this.userServices.deleteuser(id);
        return new ResponseEntity<>("user update sucessfully",HttpStatus.OK);
    }
    else{
        return new ResponseEntity<>("user not found",HttpStatus.NOT_FOUND);
    }
   }
    }