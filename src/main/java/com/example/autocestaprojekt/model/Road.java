package com.example.autocestaprojekt.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "roads")
public class Road {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String oznaka;   // npr. A1, A3, A8...


    private String ime;   //ime može biti npr. Bregana-Lipovac, Zagreb-Sisak, Goričan-Zagreb

    @OneToMany(mappedBy = "road")
    private List<Tollbooth> tollbooths;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public List<Tollbooth> getTollbooths() {
        return tollbooths;
    }

    public void setTollbooths(List<Tollbooth> tollbooths) {
        this.tollbooths = tollbooths;
    }
}
