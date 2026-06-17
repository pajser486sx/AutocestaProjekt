package com.example.autocestaprojekt.controller;

import com.example.autocestaprojekt.dto.CarDTO;
import com.example.autocestaprojekt.repository.CarRepository;
import com.example.autocestaprojekt.service.CarService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarViewController {

    private final CarService carService;

    private final CarRepository carRepository;

    public CarViewController(CarService carService, CarRepository carRepository) {
        this.carService = carService;
        this.carRepository = carRepository;
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
    public String saveCar(
            @Valid @ModelAttribute("carDTO") CarDTO carDTO,
            BindingResult bindingResult
    ) {
        if (carDTO.getRegistracija() != null &&
                carRepository.existsByRegistracijaIgnoreCase(carDTO.getRegistracija())) {

            bindingResult.rejectValue("registracija", "duplicate", "Auto s ovom registracijom već postoji!.");
        }

        if (bindingResult.hasErrors()) {
            return "cars/form";
        }

        carService.create(carDTO);
        return "redirect:/cars";
    }
}
