package com.example.autocestaprojekt.controller;

import com.example.autocestaprojekt.dto.PlateScanResponseDTO;
import com.example.autocestaprojekt.service.PlateRecognitionService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/plates")
public class PlateController {

    private final PlateRecognitionService plateRecognitionService;

    public PlateController(PlateRecognitionService plateRecognitionService) {
        this.plateRecognitionService = plateRecognitionService;
    }

    @PostMapping("/scan")
    public PlateScanResponseDTO scanPlate(@RequestParam("image") MultipartFile image) {
        return plateRecognitionService.scanPlate(image);
    }
}