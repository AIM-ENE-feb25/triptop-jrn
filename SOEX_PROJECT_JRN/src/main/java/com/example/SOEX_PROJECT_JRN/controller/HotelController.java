package com.example.SOEX_PROJECT_JRN.controller;

import com.example.SOEX_PROJECT_JRN.SecurityData;
import com.example.SOEX_PROJECT_JRN.domein.Location;
import com.example.SOEX_PROJECT_JRN.service.HotelService;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("api/hotels")
public class HotelController {

    private HotelService hotelService;
    private final RestTemplate restTemplate = new RestTemplate();
    private SecurityData securityData = new SecurityData();
    public HotelController(HotelService hotelService){
        this.hotelService = hotelService;
    }

    @GetMapping("by-location")
    public JsonNode getHotelsInArea(@RequestParam String latitude, @RequestParam String longitude) {
        return hotelService.getHotelsInArea(latitude, longitude);
    }

//    @GetMapping("by-location")
//    public ResponseEntity<JsonNode> getHotelsByLocation(
//            @RequestParam String latitude, @RequestParam String longitude) {
//
//        String url = UriComponentsBuilder.fromHttpUrl("https://booking-com.p.rapidapi.com/v1/hotels/search-by-coordinates")
//                .queryParam("children_ages", "5,0")
//                .queryParam("include_adjacency", "true")
//                .queryParam("adults_number", "2")
//                .queryParam("checkout_date", "2025-09-26")
//                .queryParam("filter_by_currency", "AED")
//                .queryParam("checkin_date", "2025-09-25")
//                .queryParam("categories_filter_ids", "class::2,class::4,free_cancellation::1")
//                .queryParam("units", "metric")
//                .queryParam("order_by", "popularity")
//                .queryParam("children_number", "2")
//                .queryParam("locale", "en-gb")
//                .queryParam("page_number", "0")
//                .queryParam("room_number", "1")
//                .queryParam("latitude", latitude)
//                .queryParam("longitude", longitude)
//                .encode()
//                .toUriString();
//
//
//        System.out.println("Request URL: " + url);
//
//        // Maak headers
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("x-rapidapi-key", securityData.getRapidApiKey());
//        headers.set("x-rapidapi-host", securityData.getBookingHost());
//        System.out.println(securityData.getRapidApiKey());
//
//        // Maak een request entity
//        HttpEntity<String> request = new HttpEntity<>(headers);
//
//        // Verstuur GET
//        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, request, JsonNode.class);
//        System.out.println(response);
//
//        // Return response
//        return ResponseEntity.ok(response.getBody());
//    }

    @PostMapping("user-location")
    public ResponseEntity<Location> getUserLocation(@RequestBody Location locationRequest) {
        return ResponseEntity.ok(locationRequest);
    }
}
