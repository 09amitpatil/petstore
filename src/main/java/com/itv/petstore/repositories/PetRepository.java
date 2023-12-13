package com.itv.petstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itv.petstore.entities.Pet;

public interface PetRepository extends JpaRepository<Pet,Integer> {

    List<Pet>findBypname(String firstname);
    
    
}
