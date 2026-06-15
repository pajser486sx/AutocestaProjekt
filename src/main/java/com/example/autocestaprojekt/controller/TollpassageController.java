package com.example.autocestaprojekt.controller;

import com.example.autocestaprojekt.service.TollpassageService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TollpassageController {

    private final TollpassageService tollpassageService;

    public TollpassageController(TollpassageService tollpassageService) {
        this.tollpassageService = tollpassageService;
    }
}
