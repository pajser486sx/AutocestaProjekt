package com.example.autocestaprojekt.dto;

public class PlateScanResponseDTO {

    private String plate;
    private double score;
    private boolean found;

    public PlateScanResponseDTO() {
    }

    public PlateScanResponseDTO(String plate, double score, boolean found) {
        this.plate = plate;
        this.score = score;
        this.found = found;
    }

    public String getPlate() {
        return plate;
    }

    public double getScore() {
        return score;
    }

    public boolean isFound() {
        return found;
    }
}