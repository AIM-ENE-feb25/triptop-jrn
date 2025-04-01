package com.example.SOEX_PROJECT_JRN.externalservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GoogleMapsService implements TransportService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String getDirections(String fromLocation, String toLocation) {
        // Construct the URL for the Google Maps Directions API
        String url = "https://maps.googleapis.com/maps/api/directions/json?origin="
                + fromLocation + "&destination=" + toLocation + "&key=YOUR_GOOGLE_MAPS_API_KEY";

        // example api call:
        // String response = restTemplate.getForObject(url, String.class);
        // For inserting the basics, we simulate the response:
        return "Simulated directions from " + fromLocation + " to " + toLocation + " using Google Maps";
    }
}
