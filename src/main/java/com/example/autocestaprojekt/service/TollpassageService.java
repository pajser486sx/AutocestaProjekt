package com.example.autocestaprojekt.service;

import com.example.autocestaprojekt.dto.TollpassageDTO;
import com.example.autocestaprojekt.model.Tollpassage;

import java.util.List;

public interface TollpassageService {
    

    List<Tollpassage> findAll();

    Tollpassage findById(Long id);

    Tollpassage create(TollpassageDTO dto);

    Tollpassage update(Long id, TollpassageDTO dto);

    void delete(Long id);
}