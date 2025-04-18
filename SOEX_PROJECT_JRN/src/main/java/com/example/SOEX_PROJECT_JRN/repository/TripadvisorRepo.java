package com.example.SOEX_PROJECT_JRN.repository;

import com.example.SOEX_PROJECT_JRN.security.TripAdvisorData;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class TripadvisorRepo implements HotelRepository {
    private final TripAdvisorData securityData = new TripAdvisorData();
    private final RestTemplate restTemplate = new RestTemplate();
    private final String BASE_URL = "https://tripadvisor16.p.rapidapi.com/api/v1/hotels/searchHotelsByLocation?";
    @Override
    public JsonNode getHotelsInArea(String latitude, String longitude) {

        String url = BASE_URL + "latitude=" + latitude + "&longitude=" + longitude + "&pageNumber=1&currencyCode=USD&checkIn=2025-09-25&checkOut=2025-09-26";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        headers.set(securityData.getSecurityData(0,0), securityData.getSecurityData(0,1));
        headers.set(securityData.getSecurityData(1,0), securityData.getSecurityData(1,1));

        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, JsonNode.class);

        // voor het gemak alleen de titel van het eerste hotel teruggeven
        JsonNode resultArray = response.getBody().get("data").get("data");

        if (resultArray != null && resultArray.isArray() && resultArray.size() > 0) {
            JsonNode firstHotel = resultArray.get(0);
            JsonNode titleNode = firstHotel.get("title");

            if (titleNode != null) {
                System.out.println("Tripadvisor first hotel request complete");
                return titleNode;
            }
        }

        System.out.println("Tripadvisor request complete");

        return response.getBody();
    }
}
