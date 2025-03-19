package com.example.HuiswerkRob;


import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

public class AppAccessChecker {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String token = "abc123";  // Vervang dit met het daadwerkelijke token van de login API
        String url = "https://triptop-identity.wiremockapi.cloud/checkAppAccess?token=" + token;

        // JSON-body met gebruikersnaam en applicatie
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("username", "edevries");
        requestBody.put("application", "triptop");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

        System.out.println("Response: " + response.getBody());
    }
}
