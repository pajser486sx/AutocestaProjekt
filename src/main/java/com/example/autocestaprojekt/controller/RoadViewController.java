package com.example.autocestaprojekt.controller;

import com.example.autocestaprojekt.dto.RoadDTO;
import com.example.autocestaprojekt.model.Road;
import com.example.autocestaprojekt.service.RoadService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RoadViewController {
    private final RoadService roadService;

    public RoadViewController(RoadService roadService) {
        this.roadService = roadService;
    }

    @GetMapping("/roads")
    public String listRoads(Model model) {
        model.addAttribute("roads", roadService.findAll());
        return "roads/list";
    }

}
