package com.example.autocestaprojekt.controller;

import com.example.autocestaprojekt.dto.TollpassageDTO;
import com.example.autocestaprojekt.service.CarService;
import com.example.autocestaprojekt.service.TollboothService;
import com.example.autocestaprojekt.service.TollpassageService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TollpassageViewController {

    private final TollpassageService tollpassageService;
    private final TollboothService tollboothService;
    private final CarService carService;

    public TollpassageViewController(
            TollpassageService tollpassageService,
            TollboothService tollboothService,
            CarService carService
    ) {
        this.tollpassageService = tollpassageService;
        this.tollboothService = tollboothService;
        this.carService = carService;
    }

    @GetMapping("/passages")
    public String listPassages(Model model) {
        model.addAttribute("passages", tollpassageService.findAll());
        return "passages/list";
    }

    @GetMapping("/passages/new")
    public String showPassageForm(Model model) {
        model.addAttribute("tollpassageDTO", new TollpassageDTO());
        model.addAttribute("tollbooths", tollboothService.findAll());
        model.addAttribute("cars", carService.findAll());

        return "passages/form";
    }

    @PostMapping("/passages")
    public String savePassage(
            @Valid @ModelAttribute("tollpassageDTO") TollpassageDTO dto
    ) {
        tollpassageService.create(dto);
        return "redirect:/passages";
    }
}