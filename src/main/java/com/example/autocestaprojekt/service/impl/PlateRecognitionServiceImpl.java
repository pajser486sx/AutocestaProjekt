package com.example.autocestaprojekt.service.impl;

import com.example.autocestaprojekt.dto.PlateScanResponseDTO;
import com.example.autocestaprojekt.service.PlateRecognitionService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PlateRecognitionServiceImpl implements PlateRecognitionService {

    @Value("${platerecognizer.api.token}")
    private String apiToken;

    @Value("${platerecognizer.api.url}")
    private String apiUrl;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public PlateScanResponseDTO scanPlate(MultipartFile image) {
        try {
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            headers.set("Authorization", "Token " + apiToken);

            ByteArrayResource imageResource = new ByteArrayResource(image.getBytes()) {
                @Override
                public String getFilename() {
                    return image.getOriginalFilename();
                }
            };

            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("upload", imageResource);

            HttpEntity<MultiValueMap<String, Object>> requestEntity =
                    new HttpEntity<>(body, headers);

            ResponseEntity<String> response = restTemplate.postForEntity(
                    apiUrl,
                    requestEntity,
                    String.class
            );

            JsonNode root = objectMapper.readTree(response.getBody());
            JsonNode results = root.get("results");

            if (results == null || !results.isArray() || results.isEmpty()) {
                return new PlateScanResponseDTO(null, 0, false);
            }

            JsonNode firstResult = results.get(0);

            String plate = firstResult.get("plate").asText();
            double score = firstResult.get("score").asDouble();

            plate = formatCroatianPlate(plate);

            return new PlateScanResponseDTO(plate, score, true);

        } catch (Exception e) {
            e.printStackTrace();
            return new PlateScanResponseDTO(null, 0, false);
        }
    }

    private String formatCroatianPlate(String plate) {
        plate = plate.toUpperCase();

        if (plate.length() > 2 && plate.charAt(2) != '-') {
            plate = plate.substring(0, 2) + "-" + plate.substring(2);
        }

        return plate;
    }
}
