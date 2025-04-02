package com.example.SOEX_PROJECT_JRN.externalservices;

import com.example.SOEX_PROJECT_JRN.model.TransportRequest;
import com.example.SOEX_PROJECT_JRN.model.TransportResponse;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.springframework.stereotype.Service;

@Service
public class WikiRoutesAdapter extends ApiCaller implements TransportProviderPort {
 // https://rapidapi.com/busmaps-busmaps-default/api/wikiroutes-api/playground/apiendpoint_3c22f402-d73c-4a2a-a7f5-6dc17391ce62
    // Create a shared HttpClient instance
    private final HttpClient httpClient = HttpClient.newHttpClient();

    // Updated RapidAPI constants
    private static final String API_KEY = "9028a74e56mshe623399d822e356p1414a2jsn3a4dffa44e24";
    private static final String API_HOST = "wikiroutes-api.p.rapidapi.com";

    @Override
    public TransportResponse fetchData(TransportRequest request) {
        return callApi(request);
    }

    @Override
    protected TransportResponse apiCall(TransportRequest request) {
        try {
            // For simplicity, assume the origin and destination are URL-encoded appropriately.
            String origin = request.getOrigin();
            String destination = request.getDestination();

            // Construct the URL (example parameters; adjust as per API documentation)
            String url = "https://wikiroutes-api.p.rapidapi.com/routes?origin="
                    + origin + "&destination=" + destination
                    + "&departureTime=2025-01-20T13:01:00&arrivalTime=2025-01-20T13:01:00&transfers=1";

            // Build the HTTP GET request with required headers
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("x-rapidapi-key", API_KEY)
                    .header("x-rapidapi-host", API_HOST)
                    .GET()
                    .build();

            // Send the request and get the response
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            // Return the response encapsulated in a TransportResponse object
            return new TransportResponse(response.body());
        } catch (Exception e) {
            e.printStackTrace();
            return new TransportResponse("Error occurred: " + e.getMessage());
        }
    }
}
