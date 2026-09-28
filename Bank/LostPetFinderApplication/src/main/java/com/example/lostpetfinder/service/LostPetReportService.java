package com.example.lostpetfinder.service;

import com.example.lostpetfinder.dto.LostPetReportRequest;
import com.example.lostpetfinder.model.LostPetReport;
import com.example.lostpetfinder.repository.LostPetReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LostPetReportService {

    private final LostPetReportRepository lostPetReportRepository;

    public LostPetReportService(
            LostPetReportRepository lostPetReportRepository) {

        this.lostPetReportRepository = lostPetReportRepository;
    }

    public LostPetReport createReport(
            LostPetReportRequest request) {

        LostPetReport report = new LostPetReport();

        report.setPetId(request.getPetId());
        report.setUserId(request.getUserId());
        report.setLostDate(request.getLostDate());
        report.setLostLocation(request.getLostLocation());
        report.setDescription(request.getDescription());

        report.setStatus("LOST");

        return lostPetReportRepository.save(report);
    }

    public List<LostPetReport> getAllReports() {
        return lostPetReportRepository.findAll();
    }

    public LostPetReport getReportById(Long id) {

        return lostPetReportRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Lost report not found with ID: " + id));
    }

    public List<LostPetReport> getActiveReports() {

        return lostPetReportRepository.findByStatus("LOST");
    }

    public LostPetReport updateStatus(
            Long id,
            String status) {

        LostPetReport report = getReportById(id);

        report.setStatus(status);

        return lostPetReportRepository.save(report);
    }

    public void deleteReport(Long id) {

        if (!lostPetReportRepository.existsById(id)) {
            throw new RuntimeException(
                    "Lost report not found with ID: " + id);
        }

        lostPetReportRepository.deleteById(id);
    }
}