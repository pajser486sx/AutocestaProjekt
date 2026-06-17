package com.example.autocestaprojekt.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CarDTO {
    private Long id;

    @NotBlank( message = "polje marka ne može biti prazno!" )
    private String marka;

    @NotBlank( message = "polje boja ne može biti prazno!" )
    private String boja;

    @NotBlank( message = "polje registracija ne može biti prazno!" )
    @Size(min = 7, message = "Registracija mora imati barem 7 znakova!")
    @Pattern(regexp = "^[A-ZČĆŽŠĐ]{2}-[A-Z0-9ČĆŽŠĐ-]+$",
            message = "Registracija mora početi sa 2 slova za grad i nakon toga '-'!")
    private String registracija;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getBoja() {
        return boja;
    }

    public void setBoja(String boja) {
        this.boja = boja;
    }

    public String getRegistracija() {
        return registracija;
    }

    public void setRegistracija(String registracija) {
        this.registracija = registracija;
    }
}
