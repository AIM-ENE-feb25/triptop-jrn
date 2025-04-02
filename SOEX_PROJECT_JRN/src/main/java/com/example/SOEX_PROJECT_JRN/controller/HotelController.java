package com.example.SOEX_PROJECT_JRN.controller;

import com.example.SOEX_PROJECT_JRN.security.SecurityData;
import com.example.SOEX_PROJECT_JRN.domein.Location;
import com.example.SOEX_PROJECT_JRN.service.HotelService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("api/hotels")
public class HotelController {

    private HotelService hotelService;
    private final RestTemplate restTemplate = new RestTemplate();
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
