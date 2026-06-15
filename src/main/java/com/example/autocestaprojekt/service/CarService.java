package com.example.autocestaprojekt.service;

import com.example.autocestaprojekt.dto.CarDTO;
import com.example.autocestaprojekt.model.Car;

import java.util.List;

public interface CarService {

    List<Car> findAll();

    Car findById(Long id);

    Car create(CarDTO dto);

    Car update(Long id, CarDTO dto);

    void delete(Long id);

}