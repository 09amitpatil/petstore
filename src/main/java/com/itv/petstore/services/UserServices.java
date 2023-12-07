package com.itv.petstore.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itv.petstore.dtos.RegistorUserDto;
import com.itv.petstore.entities.User;
import com.itv.petstore.repositories.UserRepository;
@Service
public class UserServices {
    //private Map<Integer, User> users = new HashMap<>();
    //private AtomicInteger atomic = new AtomicInteger();
    
   @Autowired
   private UserRepository repository; 
    public User registerUser(RegistorUserDto registorUserDto) {
        User user=new User();
        //user.setId(atomic.incrementAndGet());
        user.setFirstname(registorUserDto.getFirstname());
        user.setLastname(registorUserDto.getLastname());
        user.setEmail(registorUserDto.getEmail());
        user.setPassword(registorUserDto.getPassword());
        user.setMobile(registorUserDto.getMobile());
        //user.setSalary(registorUserDto.getSalary());
        //users.put(user.getId(),user);
        repository.save(user);
        return user;

    }
    public List<User> getAll() 
       {
        return repository.findAll();
       }
    public User getById(Integer id)
       {
        return repository.findById(id).orElse(null);
       }
    public void deleteuser(Integer id) 
       {
        repository.deleteById(id);
       }
    public User updateUser(Integer id,User user)
       {
        user.setId(id);
        return repository.save(user);
       }
}
