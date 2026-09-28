package com.example.lostpetfinder.repository;

import com.example.lostpetfinder.model.FoundPetReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoundPetReportRepository
        extends JpaRepository<FoundPetReport, Long> {

    List<FoundPetReport> findByStatus(String status);
}