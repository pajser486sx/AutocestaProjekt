package com.example.autocestaprojekt.dto;

import com.example.autocestaprojekt.model.Road;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RoadDTO {
    private Long id;

    @NotBlank( message = "polje ime ne može biti prazno!" )
    private String ime;

    @NotNull( message = "polje oznaka ne može biti prazno! odaberi između A1 i A11" )
    private Road.Oznaka oznaka;

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public Road.Oznaka getOznaka() {
        return oznaka;
    }

    public void setOznaka(Road.Oznaka oznaka) {
        this.oznaka = oznaka;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}