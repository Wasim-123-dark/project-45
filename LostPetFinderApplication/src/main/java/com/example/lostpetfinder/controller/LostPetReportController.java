package com.example.lostpetfinder.controller;

import com.example.lostpetfinder.dto.LostPetReportRequest;
import com.example.lostpetfinder.model.LostPetReport;
import com.example.lostpetfinder.service.LostPetReportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lost-reports")
@CrossOrigin
public class LostPetReportController {

    private final LostPetReportService service;

    public LostPetReportController(LostPetReportService service) {
        this.service = service;
    }

    @PostMapping
    public LostPetReport createReport(
            @RequestBody LostPetReportRequest request) {

        return service.createReport(request);
    }

    @GetMapping
    public List<LostPetReport> getAllReports() {
        return service.getAllReports();
    }

    @GetMapping("/{id}")
    public LostPetReport getReport(@PathVariable Long id) {
        return service.getReportById(id);
    }

    @GetMapping("/active")
    public List<LostPetReport> getActiveReports() {
        return service.getActiveReports();
    }

    @PutMapping("/{id}/status")
    public LostPetReport updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return service.updateStatus(id, status);
    }
}