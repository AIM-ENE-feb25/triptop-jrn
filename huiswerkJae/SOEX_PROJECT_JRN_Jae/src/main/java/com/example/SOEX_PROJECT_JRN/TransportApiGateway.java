package com.example.SOEX_PROJECT_JRN;

import com.example.SOEX_PROJECT_JRN.externalservices.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransportApiGateway implements ApiGateway {

    private final TransportService googleMapsService;

    @Autowired
    public TransportApiGateway(TransportService googleMapsService) {
        this.googleMapsService = googleMapsService;
    }

    @Override
    public String fetchDirections(String fromLocation, String toLocation) {
        // Calls the adapter for the external API (Google Maps in this case)
        return googleMapsService.getDirections(fromLocation, toLocation);
    }
}
