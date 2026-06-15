package com.example.autocestaprojekt.service.impl;

import com.example.autocestaprojekt.dto.TollboothDTO;
import com.example.autocestaprojekt.model.Road;
import com.example.autocestaprojekt.model.Tollbooth;
import com.example.autocestaprojekt.repository.RoadRepository;
import com.example.autocestaprojekt.repository.TollboothRepository;
import com.example.autocestaprojekt.service.TollboothService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TollboothServiceImpl implements TollboothService {

    private final TollboothRepository tollboothRepository;
    private final RoadRepository roadRepository;

    public TollboothServiceImpl(
            TollboothRepository tollboothRepository,
            RoadRepository roadRepository
    ) {
        this.tollboothRepository = tollboothRepository;
        this.roadRepository = roadRepository;
    }

    @Override
    public List<Tollbooth> findAll() {
        return tollboothRepository.findAll();
    }

    @Override
    public Tollbooth findById(Long id) {
        return tollboothRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tollbooth (naplatna postaja) nije pronađena"));
    }

    @Override
    public Tollbooth create(TollboothDTO dto) {
        Road road = roadRepository.findById(dto.getRoadId())
                .orElseThrow(() -> new RuntimeException("Road (autocesta) nije pronađena"));

        Tollbooth tollbooth = new Tollbooth();
        tollbooth.setIme(dto.getIme());
        tollbooth.setRoad(road);

        return tollboothRepository.save(tollbooth);
    }

    @Override
    public Tollbooth update(Long id, TollboothDTO dto) {
        Tollbooth tollbooth = findById(id);

        Road road = roadRepository.findById(dto.getRoadId())
                .orElseThrow(() -> new RuntimeException("Road (autocesta) nije pronađena"));

        tollbooth.setIme(dto.getIme());
        tollbooth.setRoad(road);

        return tollboothRepository.save(tollbooth);
    }

    @Override
    public void delete(Long id) {
        tollboothRepository.deleteById(id);
    }
}