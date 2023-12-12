package com.itv.petstore.repositories;

import java.util.List;

//import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.itv.petstore.entities.User;

public interface UserRepository extends JpaRepository<User,Integer> {

    List<User>findByfirstname(String firstname);
    List<User>findByemailContaining(String email);
    
}
