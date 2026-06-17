package com.example.autocestaprojekt.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "roads")
public class Road {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private Oznaka oznaka;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Oznaka getOznaka() {
        return oznaka;
    }

    public void setOznaka(Oznaka oznaka) {
        this.oznaka = oznaka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public enum Oznaka {
        A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11
    }


    private String ime;   //ime može biti npr. Bregana-Lipovac, Zagreb-Sisak, Goričan-Zagreb

    @OneToMany(mappedBy = "road")
    private List<Tollbooth> tollbooths;



    public List<Tollbooth> getTollbooths() {
        return tollbooths;
    }

    public void setTollbooths(List<Tollbooth> tollbooths) {
        this.tollbooths = tollbooths;
    }
}
