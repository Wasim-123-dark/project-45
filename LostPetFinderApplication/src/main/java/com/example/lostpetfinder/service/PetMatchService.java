package com.example.lostpetfinder.service;

import com.example.lostpetfinder.model.PetMatch;
import com.example.lostpetfinder.repository.PetMatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetMatchService {

    private final PetMatchRepository petMatchRepository;

    public PetMatchService(PetMatchRepository petMatchRepository) {
        this.petMatchRepository = petMatchRepository;
    }

    public PetMatch createMatch(
            Long lostReportId,
            Long foundReportId,
            Double percentage) {

        PetMatch match = new PetMatch();

        match.setLostReportId(lostReportId);
        match.setFoundReportId(foundReportId);
        match.setMatchPercentage(percentage);
        match.setStatus("PENDING");

        return petMatchRepository.save(match);
    }

    public List<PetMatch> getAllMatches() {
        return petMatchRepository.findAll();
    }

    public PetMatch getMatchById(Long id) {

        return petMatchRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Pet match not found with ID: " + id));
    }

    public PetMatch updateStatus(
            Long id,
            String status) {

        PetMatch match = getMatchById(id);

        match.setStatus(status);

        return petMatchRepository.save(match);
    }

    public void deleteMatch(Long id) {

        if (!petMatchRepository.existsById(id)) {
            throw new RuntimeException(
                    "Pet match not found with ID: " + id);
        }

        petMatchRepository.deleteById(id);
    }
}