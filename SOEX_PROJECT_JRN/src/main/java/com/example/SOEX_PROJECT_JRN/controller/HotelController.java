package com.example.SOEX_PROJECT_JRN.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.SOEX_PROJECT_JRN.domein.Location;
import com.example.SOEX_PROJECT_JRN.service.HotelService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/hotels")
public class HotelController {


    private HotelService hotelService;

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
