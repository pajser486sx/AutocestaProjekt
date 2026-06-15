package com.example.autocestaprojekt.service.impl;

import com.example.autocestaprojekt.dto.TollpassageDTO;
import com.example.autocestaprojekt.model.Car;
import com.example.autocestaprojekt.model.Tollbooth;
import com.example.autocestaprojekt.model.Tollpassage;
import com.example.autocestaprojekt.repository.CarRepository;
import com.example.autocestaprojekt.repository.TollboothRepository;
import com.example.autocestaprojekt.repository.TollpassageRepository;
import com.example.autocestaprojekt.service.TollpassageService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TollpassageServiceImpl implements TollpassageService {

    private final TollpassageRepository tollpassageRepository;
    private final TollboothRepository tollboothRepository;
    private final CarRepository carRepository;

    public TollpassageServiceImpl(
            TollpassageRepository tollpassageRepository,
            TollboothRepository tollboothRepository,
            CarRepository carRepository
    ) {
        this.tollpassageRepository = tollpassageRepository;
        this.tollboothRepository = tollboothRepository;
        this.carRepository = carRepository;
    }

    @Override
    public List<Tollpassage> findAll() {
        return tollpassageRepository.findAll();
    }

    @Override
    public Tollpassage findById(Long id) {
        return tollpassageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tollpassage not found"));
    }

    @Override
    public Tollpassage create(TollpassageDTO dto) {
        Tollbooth tollbooth = tollboothRepository.findById(dto.getTollboothId())
                .orElseThrow(() -> new RuntimeException("Tollbooth not found"));

        Car car = carRepository.findById(dto.getCarId())
                .orElseThrow(() -> new RuntimeException("Car not found"));

        Tollpassage tollpassage = new Tollpassage();
        tollpassage.setPassageTime(LocalDateTime.now());
        tollpassage.setTollbooth(tollbooth);
        tollpassage.setCar(car);

        return tollpassageRepository.save(tollpassage);
    }

    @Override
    public Tollpassage update(Long id, TollpassageDTO dto) {
        Tollpassage tollpassage = findById(id);

        Tollbooth tollbooth = tollboothRepository.findById(dto.getTollboothId())
                .orElseThrow(() -> new RuntimeException("Tollbooth not found"));

        Car car = carRepository.findById(dto.getCarId())
                .orElseThrow(() -> new RuntimeException("Car not found"));

        tollpassage.setTollbooth(tollbooth);
        tollpassage.setCar(car);

        return tollpassageRepository.save(tollpassage);
    }

    @Override
    public void delete(Long id) {
        tollpassageRepository.deleteById(id);
    }
}