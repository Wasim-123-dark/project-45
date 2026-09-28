package com.example.lostpetfinder.service;

import com.example.lostpetfinder.dto.PetRequest;
import com.example.lostpetfinder.model.Pet;
import com.example.lostpetfinder.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet createPet(PetRequest request) {

        Pet pet = new Pet();

        pet.setName(request.getName());
        pet.setType(request.getType());
        pet.setBreed(request.getBreed());
        pet.setColor(request.getColor());
        pet.setAge(request.getAge());
        pet.setGender(request.getGender());
        pet.setPhotoUrl(request.getPhotoUrl());
        pet.setOwnerId(request.getOwnerId());

        return petRepository.save(pet);
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Pet getPetById(Long id) {

        return petRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Pet not found with ID: " + id));
    }

    public void deletePet(Long id) {

        if (!petRepository.existsById(id)) {
            throw new RuntimeException("Pet not found with ID: " + id);
        }

        petRepository.deleteById(id);
    }
}