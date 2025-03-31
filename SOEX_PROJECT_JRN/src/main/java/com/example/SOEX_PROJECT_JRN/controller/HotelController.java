package com.example.SOEX_PROJECT_JRN.controller;

import com.example.SOEX_PROJECT_JRN.service.HotelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/hotels")
public class HotelController {

    private HotelService hotelService;
    public HotelController(HotelService hotelService){
        this.hotelService = hotelService;
    }

    @GetMapping("by-location")
    public String getHotelsByLocationId(){
        return "hotels gevonden";
    }
}
