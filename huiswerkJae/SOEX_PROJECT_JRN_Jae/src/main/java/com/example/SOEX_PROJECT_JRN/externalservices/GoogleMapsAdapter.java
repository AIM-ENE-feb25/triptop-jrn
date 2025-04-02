package com.example.SOEX_PROJECT_JRN.externalservices;

import com.example.SOEX_PROJECT_JRN.model.TransportRequest;
import com.example.SOEX_PROJECT_JRN.model.TransportResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GoogleMapsAdapter extends ApiCaller implements TransportProviderPort {

    @Autowired
    private RestTemplate restTemplate;

    // Inject your Google Maps API key from application.properties
    @Value("${google.maps.api.key}")
    private String googleMapsApiKey;

    @Override
    public TransportResponse fetchData(TransportRequest request) {
        return callApi(request);
    }

    @Override
    protected TransportResponse apiCall(TransportRequest request) {
        // Ensure the origin and destination are URL-encoded; here we simply replace spaces with '+'
        String origin = request.getOrigin().replace(" ", "+");
        String destination = request.getDestination().replace(" ", "+");

        // Construct the Google Maps Directions API URL
        String url = "https://maps.googleapis.com/maps/api/directions/json?origin="
                + origin + "&destination=" + destination + "&key=" + googleMapsApiKey;

        // Make the API call using RestTemplate
        String response = restTemplate.getForObject(url, String.class);

        // Return the response encapsulated in a TransportResponse object
        return new TransportResponse(response);
    }
}
