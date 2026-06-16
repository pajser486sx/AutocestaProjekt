package com.example.autocestaprojekt.controller;

import com.example.autocestaprojekt.dto.RoadDTO;
import com.example.autocestaprojekt.model.Road;
import com.example.autocestaprojekt.service.RoadService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roads")
public class RoadController {

    private final RoadService roadService;

    public RoadController(RoadService roadService) {
        this.roadService = roadService;
    }

    @GetMapping
    public List<Road> getAllRoads() {
        return roadService.findAll();
    }

    @GetMapping("/{id}")
    public Road getRoadById(@PathVariable Long id) {
        return roadService.findById(id);
    }

    @PostMapping
    public Road createRoad(@Valid @RequestBody RoadDTO roadDTO) {
        return roadService.create(roadDTO);
    }

    @PutMapping("/{id}")
    public Road updateRoad(@PathVariable Long id, @Valid @RequestBody RoadDTO roadDTO) {
        return roadService.update(id, roadDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteRoad(@PathVariable Long id) {
        roadService.delete(id);
    }
}