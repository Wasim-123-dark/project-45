package com.example.lostpetfinder.controller;

import com.example.lostpetfinder.model.PetMatch;
import com.example.lostpetfinder.service.PetMatchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
@CrossOrigin
public class PetMatchController {

    private final PetMatchService petMatchService;

    public PetMatchController(PetMatchService petMatchService) {
        this.petMatchService = petMatchService;
    }

    @PostMapping
    public PetMatch createMatch(
            @RequestParam Long lostReportId,
            @RequestParam Long foundReportId,
            @RequestParam Double percentage) {

        return petMatchService.createMatch(
                lostReportId,
                foundReportId,
                percentage
        );
    }

    @GetMapping
    public List<PetMatch> getAllMatches() {
        return petMatchService.getAllMatches();
    }

    @GetMapping("/{id}")
    public PetMatch getMatchById(@PathVariable Long id) {
        return petMatchService.getMatchById(id);
    }

    @PutMapping("/{id}/status")
    public PetMatch updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return petMatchService.updateStatus(id, status);
    }
}