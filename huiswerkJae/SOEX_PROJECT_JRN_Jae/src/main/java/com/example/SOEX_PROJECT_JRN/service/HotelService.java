package com.example.SOEX_PROJECT_JRN.service;

import com.example.SOEX_PROJECT_JRN.ApiGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {

    private final ApiGateway transportApiGateway;

    @Autowired
    public HotelService(ApiGateway transportApiGateway) {
        this.transportApiGateway = transportApiGateway;
    }

    public String getHotelsByLocation(String fromLocation, String toLocation) {
        // Retrieve directions from the external transport service
        String directions = transportApiGateway.fetchDirections(fromLocation, toLocation);
        // Combine hotel info with the directions (for demonstration)
        return "Hotel info + " + directions;
    }
}
