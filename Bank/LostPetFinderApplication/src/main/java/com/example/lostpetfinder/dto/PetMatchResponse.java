package com.example.lostpetfinder.dto;

public class PetMatchResponse {

    private Long lostReportId;
    private Long foundReportId;
    private Double matchPercentage;
    private String status;

    public PetMatchResponse() {
    }

    public Long getLostReportId() {
        return lostReportId;
    }

    public void setLostReportId(Long lostReportId) {
        this.lostReportId = lostReportId;
    }

    public Long getFoundReportId() {
        return foundReportId;
    }

    public void setFoundReportId(Long foundReportId) {
        this.foundReportId = foundReportId;
    }

    public Double getMatchPercentage() {
        return matchPercentage;
    }

    public void setMatchPercentage(Double matchPercentage) {
        this.matchPercentage = matchPercentage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}