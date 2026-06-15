package com.example.autocestaprojekt.controller;

import com.example.autocestaprojekt.dto.TollpassageDTO;
import com.example.autocestaprojekt.model.Tollpassage;
import com.example.autocestaprojekt.service.TollpassageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tollpassages")
public class TollpassageController {

    private final TollpassageService tollpassageService;

    public TollpassageController(TollpassageService tollpassageService) {
        this.tollpassageService = tollpassageService;
    }

    @GetMapping
    public List<Tollpassage> getAllTollpassages() {
        return tollpassageService.findAll();
    }

    @GetMapping("/{id}")
    public Tollpassage getTollpassageById(@PathVariable Long id) {
        return tollpassageService.findById(id);
    }

    @PostMapping
    public Tollpassage createTollpassage(@RequestBody TollpassageDTO tollpassageDTO) {
        return tollpassageService.create(tollpassageDTO);
    }

    @PutMapping("/{id}")
    public Tollpassage updateTollpassage(@PathVariable Long id, @RequestBody TollpassageDTO tollpassageDTO) {
        return tollpassageService.update(id, tollpassageDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTollpassage(@PathVariable Long id) {
        tollpassageService.delete(id);
    }
}