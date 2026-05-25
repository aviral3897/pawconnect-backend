
package com.pawconnect.controller;

import com.pawconnect.model.Pet;
import com.pawconnect.repository.PetRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pets")

public class PetController {

    private final PetRepository petRepository;

    public PetController(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    // ADD PET

    @PostMapping("/add")
    public Pet addPet(@RequestBody Pet pet) {

        return petRepository.save(pet);
    }

    // GET ALL PETS

    @GetMapping
    public List<Pet> getAllPets() {

        return petRepository.findAll();
    }

    @GetMapping("/myPets/{email}")
    public List<Pet> getMyPets(@PathVariable String email) {

        return petRepository.findByOwnerEmail(email);
    }

    @GetMapping("/nearby/{email}")
    public List<Pet> getNearbyPets(@PathVariable String email) {

        return petRepository.findByOwnerEmailNot(email);
    }

    // DELETE PET


    @DeleteMapping("/delete/{id}")
    public String deletePet(@PathVariable Long id) {

        petRepository.deleteById(id);

        return "Pet deleted successfully!";
    }


}