package TripTropExperiment.demo;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
public class AccessCheckService {

    private final RestTemplate restTemplate;

    public AccessCheckService() {
        this.restTemplate = new RestTemplate();
    }

    public void checkAppAccess(String username, String application, String token) {
        String accessUrl = "http://localhost:8080/checkAppAccess?token=" + token;

        // Prepare JSON body using a Map
        Map<String, String> accessRequestBody = new HashMap<>();
        accessRequestBody.put("username", username);
        accessRequestBody.put("application", application);

        // Create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(accessRequestBody, headers);

        // Execute access check request
        ResponseEntity<String> response = restTemplate.exchange(accessUrl, HttpMethod.POST, request, String.class);

        System.out.println("Access Check Response: " + response.getBody());
    }
}

