package com.example.autocestaprojekt.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tollbooths")
public class Tollbooth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ime;

    @ManyToOne
    @JoinColumn(name = "road_id")
    private Road road;

    @OneToMany(mappedBy = "tollbooth")
    private List<Tollpassage> tollpassages;

    public Long getId() {
        return id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public Road getRoad() {
        return road;
    }

    public void setRoad(Road road) {
        this.road = road;
    }

    public List<Tollpassage> getTollpassages() {
        return tollpassages;
    }

    public void setTollpassages(List<Tollpassage> tollpassages) {
        this.tollpassages = tollpassages;
    }
}