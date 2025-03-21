package TripTropExperiment.demo;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class AppAccessRequest {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String token = "abc123";  // Replace this with the token you retrieved
        String url = "https://triptop-identity.wiremockapi.cloud/checkAppAccess?token=" + token;

        // Prepare the request body
        String jsonBody = "{\"username\":\"edevries\", \"application\":\"triptop\"}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create request entity
        HttpEntity<String> request = new HttpEntity<>(jsonBody, headers);

        // Send POST request
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        System.out.println("Response: " + response.getBody());
    }
}
