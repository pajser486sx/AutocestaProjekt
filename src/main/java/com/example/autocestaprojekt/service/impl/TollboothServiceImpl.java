package com.example.autocestaprojekt.service.impl;

import com.example.autocestaprojekt.dto.TollboothDTO;
import com.example.autocestaprojekt.model.Road;
import com.example.autocestaprojekt.model.Tollbooth;
import com.example.autocestaprojekt.repository.RoadRepository;
import com.example.autocestaprojekt.repository.TollboothRepository;
import com.example.autocestaprojekt.service.TollboothService;
import com.example.autocestaprojekt.validation.TollboothValidator;
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
    public Tollbooth create(TollboothDTO tollboothDTO) {

        if (!TollboothValidator.isValidTollboothForRoad(
                tollboothDTO.getOznaka(),
                tollboothDTO.getIme()
        )) {
            throw new IllegalArgumentException("Invalid tollbooth for selected road.");
        }

        Road road = roadRepository.findByOznaka(tollboothDTO.getOznaka())
                .orElseThrow(() -> new RuntimeException("Road (autocesta) not found."));

        Tollbooth tollbooth = new Tollbooth();
        tollbooth.setIme(tollboothDTO.getIme());
        tollbooth.setRoad(road);

        return tollboothRepository.save(tollbooth);
    }

    @Override
    public Tollbooth update(Long id, TollboothDTO dto) {
        Tollbooth tollbooth = findById(id);

        if (!TollboothValidator.isValidTollboothForRoad(
                dto.getOznaka(),
                dto.getIme()
        )) {
            throw new IllegalArgumentException("Invalid tollbooth for selected road.");
        }

        Road road = roadRepository.findByOznaka(dto.getOznaka())
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