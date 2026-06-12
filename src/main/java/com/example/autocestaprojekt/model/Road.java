package com.example.autocestaprojekt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "roads")
public class Road {
    private Long id;
    private String oznaka;   // npr. A1, A3, A8...
    private String ime;   //ime može biti npr. Bregana-Lipovac, Zagreb-Sisak, Goričan-Zagreb
}
