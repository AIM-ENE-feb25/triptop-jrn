package com.example.SOEX_PROJECT_JRN.externalservices;

import com.example.SOEX_PROJECT_JRN.model.TransportRequest;
import com.example.SOEX_PROJECT_JRN.model.TransportResponse;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.springframework.stereotype.Service;

@Service
public class BusMapsAdapter extends ApiCaller implements TransportProviderPort {

    private final HttpClient httpClient = HttpClient.newHttpClient();
    private static final String API_KEY = "9028a74e56mshe623399d822e356p1414a2jsn3a4dffa44e24";
    private static final String API_HOST = "busmaps-gtfs-api.p.rapidapi.com";

    @Override
    public TransportResponse fetchData(TransportRequest request) {
        return callApi(request);
    }

    @Override
    protected TransportResponse apiCall(TransportRequest request) {
        try {
            // URL based on the provided sample with fixed parameters.
            String url = "https://busmaps-gtfs-api.p.rapidapi.com/routes?origin=51.507198%2C-0.136512&destination=51.505983%2C-0.017931&departureTime=2025-02-11T09%3A06%3A00&arrivalTime=2025-02-11T09%3A06%3A00&transfers=1";

            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("x-rapidapi-key", API_KEY)
                    .header("x-rapidapi-host", API_HOST)
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return new TransportResponse(response.body());
        } catch (Exception e) {
            e.printStackTrace();
            return new TransportResponse("Error occurred: " + e.getMessage());
        }
    }
}
