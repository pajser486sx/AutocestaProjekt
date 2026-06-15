package com.example.autocestaprojekt.dto;

import com.example.autocestaprojekt.model.Road;

public class TollboothDTO {
    private Long id;
    private String ime;
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