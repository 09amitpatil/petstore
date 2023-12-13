package com.itv.petstore.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itv.petstore.dtos.RegistorPetDto;
import com.itv.petstore.entities.Pet;
import com.itv.petstore.repositories.PetRepository;
@Service
public class PetServices {
   
   @Autowired
   private PetRepository repository; 
    public Pet registerPet(RegistorPetDto registorPetDto) {
        Pet pet=new Pet();
        pet.setPname(registorPetDto.getPname());
        pet.setPtype(registorPetDto.getPtype());
        pet.setPassword(registorPetDto.getPassword());
        pet.setMobile(registorPetDto.getMobile());
        repository.save(pet);
        return pet;

    }
    public List<Pet> getAll() 
       {
        return repository.findAll();
       }
    public Pet getById(Integer id)
       {
        return repository.findById(id).orElse(null);
       }
    public void deletepet(Integer id) 
       {
        repository.deleteById(id);
       }
    public Pet updatePet(Integer id,Pet pet)
       {
        pet.setId(id);
        return repository.save(pet);
       }

       public   List<Pet>findByfirstname(String firstname)
       {
         return this.repository.findBypname(firstname);
       }

       

 

}
