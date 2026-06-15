package com.example.autocestaprojekt.service.impl;

import com.example.autocestaprojekt.dto.RoadDTO;
import com.example.autocestaprojekt.model.Road;
import com.example.autocestaprojekt.repository.RoadRepository;
import com.example.autocestaprojekt.service.RoadService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoadServiceImpl implements RoadService {

    private final RoadRepository roadRepository;

    public RoadServiceImpl(RoadRepository roadRepository) {
        this.roadRepository = roadRepository;
    }

    @Override
    public List<Road> findAll() {
        return roadRepository.findAll();
    }

    @Override
    public Road findById(Long id) {
        return roadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Road (autocesta) nije pronađena"));
    }

    @Override
    public Road create(RoadDTO dto) {
        Road road = new Road();

        road.setOznaka(dto.getOznaka());
        road.setIme(dto.getIme());

        return roadRepository.save(road);
    }

    @Override
    public Road update(Long id, RoadDTO dto) {
        Road road = findById(id);

        road.setOznaka(dto.getOznaka());
        road.setIme(dto.getIme());

        return roadRepository.save(road);
    }

    @Override
    public void delete(Long id) {
        roadRepository.deleteById(id);
    }
}