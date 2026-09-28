package com.example.lostpetfinder.controller;

import com.example.lostpetfinder.dto.FoundPetReportRequest;
import com.example.lostpetfinder.model.FoundPetReport;
import com.example.lostpetfinder.service.FoundPetReportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/found-reports")
@CrossOrigin
public class FoundPetReportController {

    private final FoundPetReportService service;

    public FoundPetReportController(FoundPetReportService service) {
        this.service = service;
    }

    @PostMapping
    public FoundPetReport createReport(
            @RequestBody FoundPetReportRequest request) {

        return service.createReport(request);
    }

    @GetMapping
    public List<FoundPetReport> getAllReports() {
        return service.getAllReports();
    }

    @GetMapping("/{id}")
    public FoundPetReport getReport(@PathVariable Long id) {
        return service.getReportById(id);
    }

    @GetMapping("/active")
    public List<FoundPetReport> getActiveReports() {
        return service.getActiveReports();
    }

    @PutMapping("/{id}/status")
    public FoundPetReport updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return service.updateStatus(id, status);
    }
}