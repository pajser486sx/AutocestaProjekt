package com.example.autocestaprojekt.controller;

import com.example.autocestaprojekt.model.Road;
import com.example.autocestaprojekt.service.TollboothService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TollboothViewController {

    private final TollboothService tollboothService;

    public TollboothViewController(TollboothService tollboothService) {
        this.tollboothService = tollboothService;
    }

    @GetMapping("/tollbooths")
    public String listTollbooths(Model model) {
        model.addAttribute("tollbooths", tollboothService.findAll());
        model.addAttribute("roads", Road.Oznaka.values());

        return "tollbooths/list";
    }
}