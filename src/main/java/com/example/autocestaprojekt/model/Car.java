package com.example.autocestaprojekt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cars")
public class Car {
    private Long id;
    private String marka;
    private String boja;
}
