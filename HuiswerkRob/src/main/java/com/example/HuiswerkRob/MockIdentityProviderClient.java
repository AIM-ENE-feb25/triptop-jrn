package com.example.HuiswerkRob;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

public class MockIdentityProviderClient {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://triptop-identity.wiremockapi.cloud/login";

        // JSON-body met gebruikersnaam en wachtwoord
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("username", "edevries");
        requestBody.put("password", "3g2Rw9sT1x");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

        System.out.println("Response: " + response.getBody());
    }
}
