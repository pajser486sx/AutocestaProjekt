package com.example.autocestaprojekt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tollbooths")
public class Tollbooth {
    private Long id;
    private String ime;
}
