package com.example.autocestaprojekt.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TollpassageDTO {
    private Long id;

    @NotNull( message = "odaberi NP kojoj pripada prolaz!" )
    private Long tollboothId;

    @NotNull( message = "odaberi auto koji je prošao!" )
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}