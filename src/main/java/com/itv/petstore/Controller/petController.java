package com.itv.petstore.Controller;

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

import com.itv.petstore.dtos.RegistorPetDto;
import com.itv.petstore.entities.Pet;
import com.itv.petstore.services.PetServices;
import jakarta.validation.Valid;

@RestController
public class petController {
    @Autowired
    private PetServices petServices;
//adding data
    @PostMapping("/pets")
    public ResponseEntity<?> registerPet(@RequestBody  @Valid RegistorPetDto registerPetDto)
    {
        return  new  ResponseEntity<>(this.petServices.registerPet(registerPetDto),HttpStatus.CREATED);
    }
    //retriving data
    @GetMapping("/pets")
   public ResponseEntity<?>getAll()
   {
    return ResponseEntity.ok(this.petServices.getAll());
   }
  //searching data
  @GetMapping("/pets/{id}")
public ResponseEntity<?>getById(@PathVariable Integer id)
   {
    Pet petExits=this.petServices.getById(id);
    if(petExits!=null)
    {
        return new ResponseEntity<>(petExits,HttpStatus.OK);
    }
    else{
        return new ResponseEntity<>("Pet not found",HttpStatus.NOT_FOUND);
    }
   }
    @DeleteMapping("/pets/{id}")
   public ResponseEntity<?>deletepet(@PathVariable Integer id)
   {
    Pet petExits=this.petServices.getById(id);
    if(petExits!=null)
    {
        this.petServices.deletepet(id);
        return new ResponseEntity<>("Pet deleted sucessfully",HttpStatus.OK);
    }
    else{
        return new ResponseEntity<>("Pet not found",HttpStatus.NOT_FOUND);
    }
   }
   @PutMapping("/pets/{id}")
   public ResponseEntity<?>updatepet(@PathVariable Integer id)
   {
    Pet petExits=this.petServices.getById(id);
    if(petExits!=null)
    {
        this.petServices.deletepet(id);
        return new ResponseEntity<>("Pet update sucessfully",HttpStatus.OK);
    }
    else{
        return new ResponseEntity<>("Pet not found",HttpStatus.NOT_FOUND);
    }
   }

  /*@GetMapping("/pets/searchbyfname")
   public ResponseEntity<?>findByFirstname(@RequestParam("firstname")String firstname)
   {
   List<Pet>pets= this.petServices.findByfirstname(firstname);
    if(pets.isEmpty())
    {
     return new ResponseEntity<>("no Pet exist with this  name",HttpStatus.NOT_FOUND);
    }
else
{
    return new ResponseEntity<>(this.petServices.findBypname(firstname),HttpStatus.NOT_FOUND);
    }  
}*/

 
}