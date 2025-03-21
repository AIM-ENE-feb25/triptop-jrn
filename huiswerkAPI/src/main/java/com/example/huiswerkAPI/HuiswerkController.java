package com.example.huiswerkAPI;

import com.fasterxml.jackson.databind.JsonNode;
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
    public ResponseEntity<JsonNode> getAttractionReviews(
            @RequestParam String id,
            @RequestParam(defaultValue = "1") int page,
            @RequestHeader("x-rapidapi-key") String rapidApiKey,
            @RequestHeader("x-rapidapi-host") String rapidApiHost) {

        String url = "https://booking-com15.p.rapidapi.com/api/v1/attraction/getAttractionReviews?id=" + id + "&page=" + page;

        // Maak headers aan
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", rapidApiKey);
        headers.set("x-rapidapi-host", rapidApiHost);

        // Maak een request entity aan (zonder body omdat het een GET is)
        HttpEntity<String> request = new HttpEntity<>(headers);

        // Verstuur GET-aanvraag en ontvang response
        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, request, JsonNode.class);

        return ResponseEntity.ok(response.getBody());
    }
}
