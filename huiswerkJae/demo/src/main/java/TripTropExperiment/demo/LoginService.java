package TripTropExperiment.demo;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public LoginService() {
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
    }

    public String performLogin(String username, String password) {
        String loginUrl = "https://triptop-identity.wiremockapi.cloud/login";

        // Prepare JSON body using a Map
        Map<String, String> loginRequestBody = new HashMap<>();
        loginRequestBody.put("username", username);
        loginRequestBody.put("password", password);

        // Create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(loginRequestBody, headers);

        // Execute login request
        ResponseEntity<String> response = restTemplate.exchange(loginUrl, HttpMethod.POST, request, String.class);

        System.out.println("Login Response: " + response.getBody());

        try {
            JsonNode rootNode = objectMapper.readTree(response.getBody());
            return rootNode.path("token").asText();
        } catch (Exception e) {
            System.err.println("Error parsing login response: " + e.getMessage());
            return null;
        }
    }
}
