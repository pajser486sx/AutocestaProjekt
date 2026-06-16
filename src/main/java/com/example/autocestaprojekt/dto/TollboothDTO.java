package com.example.autocestaprojekt.dto;

import com.example.autocestaprojekt.model.Road;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TollboothDTO {
    private Long id;

    @NotBlank( message = "polje ime ne može biti prazno! odaberi iz liste dozvoljenih za određenu dionicu ceste" )
    private String ime;

    @NotNull( message = "polje oznaka ne može biti prazno! odaberi iz liste A1 - A11" )
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