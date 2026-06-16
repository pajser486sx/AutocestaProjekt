package com.example.autocestaprojekt.controller;

import com.example.autocestaprojekt.dto.CarDTO;
import com.example.autocestaprojekt.service.CarService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarViewController {

    private final CarService carService;

    public CarViewController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String listCars(Model model) {
        model.addAttribute("cars", carService.findAll());
        return "cars/list";
    }

    @GetMapping("/cars/new")
    public String showCarForm(Model model) {
        model.addAttribute("carDTO", new CarDTO());
        return "cars/form";
    }

    @PostMapping("/cars")
    public String saveCar(@Valid @ModelAttribute("carDTO") CarDTO carDTO) {
        carService.create(carDTO);
        return "redirect:/cars";
    }
}
