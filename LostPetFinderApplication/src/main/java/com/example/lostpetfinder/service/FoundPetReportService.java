package com.example.lostpetfinder.service;

import com.example.lostpetfinder.dto.FoundPetReportRequest;
import com.example.lostpetfinder.model.FoundPetReport;
import com.example.lostpetfinder.repository.FoundPetReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoundPetReportService {

    private final FoundPetReportRepository foundPetReportRepository;

    public FoundPetReportService(
            FoundPetReportRepository foundPetReportRepository) {

        this.foundPetReportRepository = foundPetReportRepository;
    }

    public FoundPetReport createReport(
            FoundPetReportRequest request) {

        FoundPetReport report = new FoundPetReport();

        report.setPetId(request.getPetId());
        report.setUserId(request.getUserId());
        report.setFoundDate(request.getFoundDate());
        report.setFoundLocation(request.getFoundLocation());
        report.setDescription(request.getDescription());

        report.setStatus("FOUND");

        return foundPetReportRepository.save(report);
    }

    public List<FoundPetReport> getAllReports() {
        return foundPetReportRepository.findAll();
    }

    public FoundPetReport getReportById(Long id) {

        return foundPetReportRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Found report not found with ID: " + id));
    }

    public List<FoundPetReport> getActiveReports() {

        return foundPetReportRepository.findByStatus("FOUND");
    }

    public FoundPetReport updateStatus(
            Long id,
            String status) {

        FoundPetReport report = getReportById(id);

        report.setStatus(status);

        return foundPetReportRepository.save(report);
    }

    public void deleteReport(Long id) {

        if (!foundPetReportRepository.existsById(id)) {
            throw new RuntimeException(
                    "Found report not found with ID: " + id);
        }

        foundPetReportRepository.deleteById(id);
    }
}