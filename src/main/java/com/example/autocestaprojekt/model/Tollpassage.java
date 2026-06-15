package com.example.autocestaprojekt.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tollpassages")
public class Tollpassage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime passageTime;

    @ManyToOne
    @JoinColumn(name = "tollbooth_id", nullable = false)
    private Tollbooth tollbooth;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    public Long getId() {
        return id;
    }

    public LocalDateTime getPassageTime() {
        return passageTime;
    }

    public void setPassageTime(LocalDateTime passageTime) {
        this.passageTime = passageTime;
    }

    public Tollbooth getTollbooth() {
        return tollbooth;
    }

    public void setTollbooth(Tollbooth tollbooth) {
        this.tollbooth = tollbooth;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}