package TripTropExperiment.demo;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class LoginRequest {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://triptop-identity.wiremockapi.cloud/login";

        // Prepare the request body
        String jsonBody = "{\"username\":\"edevries\", \"password\":\"3g2Rw9sT1x\"}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create request entity
        HttpEntity<String> request = new HttpEntity<>(jsonBody, headers);

        // Send POST request
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        System.out.println("Response: " + response.getBody());

        // Parse the token (just a simple extraction for demonstration)
        String token = response.getBody().split(":")[1].replaceAll("[\"}]", "").trim();
        System.out.println("Token: " + token);  // Use the token in the next request
    }
}
