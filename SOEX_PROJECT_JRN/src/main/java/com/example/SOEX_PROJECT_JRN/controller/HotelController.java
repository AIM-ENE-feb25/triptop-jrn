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
    public List<JsonNode> getHotelsInArea(@RequestParam String latitude, @RequestParam String longitude) {
        return hotelService.getHotelsInArea(latitude, longitude);
    }

    @PostMapping("user-location")
    public ResponseEntity<Location> getUserLocation(@RequestBody Location locationRequest) {
        return ResponseEntity.ok(locationRequest);
    }
}
