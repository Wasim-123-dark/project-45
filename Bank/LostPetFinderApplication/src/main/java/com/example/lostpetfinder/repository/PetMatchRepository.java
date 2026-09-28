package com.example.lostpetfinder.repository;

import com.example.lostpetfinder.model.PetMatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetMatchRepository extends JpaRepository<PetMatch, Long> {
}