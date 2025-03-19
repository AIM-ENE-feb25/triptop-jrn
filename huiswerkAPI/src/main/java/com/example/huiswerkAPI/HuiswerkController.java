package com.example.huiswerkAPI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/huiswerk")
public class HuiswerkController {

    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/mocklogin")
    public ResponseEntity<String> mockLogin(@RequestBody LoginRequest loginRequest) {
        String url = "https://triptop-identity.wiremockapi.cloud/login";

        // Maak headers aan
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Zet de request body in een HttpEntity object
        HttpEntity<LoginRequest> request = new HttpEntity<>(loginRequest, headers);

        // Verstuur de POST-aanvraag naar WireMock
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        return ResponseEntity.ok(response.getBody());
    }
}
