package com.example.autocestaprojekt.controller;

import com.example.autocestaprojekt.dto.TollboothDTO;
import com.example.autocestaprojekt.model.Tollbooth;
import com.example.autocestaprojekt.service.TollboothService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tollbooths")
public class TollboothController {

    private final TollboothService tollboothService;

    public TollboothController(TollboothService tollboothService) {
        this.tollboothService = tollboothService;
    }

    @GetMapping
    public List<Tollbooth> getAllTollbooths() {
        return tollboothService.findAll();
    }

    @GetMapping("/{id}")
    public Tollbooth getTollboothById(@PathVariable Long id) {
        return tollboothService.findById(id);
    }

    @PostMapping
    public Tollbooth createTollbooth(@Valid @RequestBody TollboothDTO tollboothDTO) {
        return tollboothService.create(tollboothDTO);
    }

    @PutMapping("/{id}")
    public Tollbooth updateTollbooth(@PathVariable Long id,@Valid  @RequestBody TollboothDTO tollboothDTO) {
        return tollboothService.update(id, tollboothDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTollbooth(@PathVariable Long id) {
        tollboothService.delete(id);
    }
}