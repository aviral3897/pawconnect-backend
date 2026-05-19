package com.pawconnect.controller;

import com.pawconnect.model.Pet;
import com.pawconnect.repository.PetRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetRepository petRepository;

    public PetController(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @PostMapping
    public Pet addPet(@RequestBody Pet pet) {
        return petRepository.save(pet);
    }

    @GetMapping
    public java.util.List<Pet> getPets() {
        return petRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pet getPetById(@PathVariable Long id) {
        return petRepository.findById(id).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable Long id) {
        petRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Pet updatePet(@PathVariable Long id, @RequestBody Pet updatedPet) {

        Pet pet = petRepository.findById(id).orElseThrow();

        pet.setName(updatedPet.getName());
        pet.setType(updatedPet.getType());
        pet.setBreed(updatedPet.getBreed());
        pet.setLocation(updatedPet.getLocation());
        pet.setContactNumber(updatedPet.getContactNumber());

        return petRepository.save(pet);
    }
}