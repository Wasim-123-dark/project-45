package com.example.lostpetfinder.controller;

import com.example.lostpetfinder.dto.PetRequest;
import com.example.lostpetfinder.model.Pet;
import com.example.lostpetfinder.service.PetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
@CrossOrigin
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    public Pet createPet(@RequestBody PetRequest request) {
        return petService.createPet(request);
    }

    @GetMapping
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @GetMapping("/{id}")
    public Pet getPet(@PathVariable Long id) {
        return petService.getPetById(id);
    }

    @DeleteMapping("/{id}")
    public String deletePet(@PathVariable Long id) {
        petService.deletePet(id);
        return "Pet deleted successfully";
    }
}