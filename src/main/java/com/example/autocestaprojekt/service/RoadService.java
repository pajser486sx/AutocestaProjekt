package com.example.autocestaprojekt.service;

import com.example.autocestaprojekt.dto.RoadDTO;
import com.example.autocestaprojekt.model.Road;

import java.util.List;

public interface RoadService {

    List<Road> findAll();

    Road findById(Long id);

    Road create(RoadDTO dto);

    Road update(Long id, RoadDTO dto);

    void delete(Long id);
}