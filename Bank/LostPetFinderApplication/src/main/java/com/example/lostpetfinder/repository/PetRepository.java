package com.example.lostpetfinder.repository;

import com.example.lostpetfinder.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}