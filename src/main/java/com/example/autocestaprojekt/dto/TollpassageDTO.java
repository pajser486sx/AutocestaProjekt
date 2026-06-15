package com.example.autocestaprojekt.dto;

public class TollpassageDTO {
    private Long id;
    private Long tollboothId;
    private Long carId;

    public Long getTollboothId() {
        return tollboothId;
    }

    public void setTollboothId(Long tollboothId) {
        this.tollboothId = tollboothId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }
}