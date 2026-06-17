package com.example.autocestaprojekt.service;

import com.example.autocestaprojekt.dto.PlateScanResponseDTO;
import org.springframework.web.multipart.MultipartFile;

public interface PlateRecognitionService {
    PlateScanResponseDTO scanPlate(MultipartFile image);
}
