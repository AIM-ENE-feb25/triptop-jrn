package com.example.huiswerkAPI;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

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

    @GetMapping("/reviews")
    public ResponseEntity<String> getAttractionReviews(@RequestParam String id, @RequestParam(defaultValue = "1") int page) {
        String url = "https://booking-com15.p.rapidapi.com/api/v1/attraction/getAttractionReviews?id=" + id + "&page=" + page;

        // Maak headers aan
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", "c70851b4c7msh277df39776047c1p15ca0ajsnc9fc22ec0514");
        headers.set("x-rapidapi-host", "booking-com15.p.rapidapi.com");

        // Maak een request entity aan (zonder body omdat het een GET is)
        HttpEntity<String> request = new HttpEntity<>(headers);

        // Verstuur GET-aanvraag en ontvang response
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);

        return ResponseEntity.ok(response.getBody());
    }
}
