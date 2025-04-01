package com.example.SOEX_PROJECT_JRN.repository;

import com.example.SOEX_PROJECT_JRN.SecurityData;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class TripadvisorRepo implements HotelRepository {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String BASE_URL = "https://tripadvisor16.p.rapidapi.com/api/v1/hotels/searchHotelsByLocation?";
    @Override
    public JsonNode getHotelsInArea(String latitude, String longitude, HttpHeaders headers) {

        String url = BASE_URL + "latitude=" + latitude + "&longitude=" + longitude + "&pageNumber=1&currencyCode=USD&checkIn=2025-09-25&checkOut=2025-09-26";

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        headers.set(securityData.getTripadvisorData(0,0), securityData.getTripadvisorData(0,1));
        headers.set(securityData.getTripadvisorData(1,0), securityData.getTripadvisorData(1,1));

        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, JsonNode.class);

        JsonNode resultArray = response.getBody().get("data");

        JsonNode firstHotel = resultArray.get(0);

        return firstHotel;
    }
}
