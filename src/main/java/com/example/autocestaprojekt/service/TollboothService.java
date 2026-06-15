package com.example.autocestaprojekt.service;

import com.example.autocestaprojekt.dto.TollboothDTO;
import com.example.autocestaprojekt.model.Tollbooth;

import java.util.List;

public interface TollboothService {

    List<Tollbooth> findAll();

    Tollbooth findById(Long id);

    Tollbooth create(TollboothDTO dto);

    Tollbooth update(Long id, TollboothDTO dto);

    void delete(Long id);
}