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

    // Create a shared HttpClient instance
    private final HttpClient httpClient = HttpClient.newHttpClient();

    @Override
    public TransportResponse fetchData(TransportRequest request) {
        return callApi(request);
    }

    @Override
    protected TransportResponse apiCall(TransportRequest request) {
        try {
            // For simplicity, assume the origin and destination are already URL-encoded or adjust accordingly.
            String origin = request.getOrigin();
            String destination = request.getDestination();

            // Construct the URL (this is a simplified example)
            String url = "https://wikiroutes-api.p.rapidapi.com/routes?origin="
                    + origin + "&destination=" + destination
                    + "&departureTime=2025-01-20T13:01:00&arrivalTime=2025-01-20T13:01:00&transfers=1";

            // Create the HTTP GET request and add required headers
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("x-rapidapi-host", "wikiroutes-api.p.rapidapi.com")
                    // If needed, add your API key header here, e.g.:
                    // .header("x-rapidapi-key", "YOUR_API_KEY")
                    .GET()
                    .build();

            // Send the request and wait for the response
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            // Return the response encapsulated in a TransportResponse object
            return new TransportResponse(response.body());
        } catch (Exception e) {
            e.printStackTrace();
            return new TransportResponse("Error occurred: " + e.getMessage());
        }
    }
}
