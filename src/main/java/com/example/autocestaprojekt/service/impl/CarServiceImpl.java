package com.example.autocestaprojekt.service.impl;

import com.example.autocestaprojekt.dto.CarDTO;
import com.example.autocestaprojekt.model.Car;
import com.example.autocestaprojekt.repository.CarRepository;
import com.example.autocestaprojekt.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Car findById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car (auto) nije pronađen"));
    }

    @Override
    public Car create(CarDTO dto) {

        if (carRepository.existsByRegistracijaIgnoreCase(dto.getRegistracija())) {
            throw new IllegalArgumentException("Već postoji auto s ovom registracijom.");
        }

        Car car = new Car();
        car.setMarka(dto.getMarka());
        car.setRegistracija(dto.getRegistracija());
        car.setBoja(dto.getBoja());

        return carRepository.save(car);
    }

    @Override
    public Car update(Long id, CarDTO dto) {
        Car car = findById(id);

        car.setMarka(dto.getMarka());
        car.setBoja(dto.getBoja());
        car.setRegistracija(dto.getRegistracija());

        return carRepository.save(car);
    }

    @Override
    public void delete(Long id) {
        carRepository.deleteById(id);
    }
}
