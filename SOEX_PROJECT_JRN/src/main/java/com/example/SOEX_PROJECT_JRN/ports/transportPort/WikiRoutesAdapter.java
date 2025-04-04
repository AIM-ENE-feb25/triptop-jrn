package com.example.SOEX_PROJECT_JRN.externalservices;

import com.example.SOEX_PROJECT_JRN.ApiCaller;
import com.example.SOEX_PROJECT_JRN.model.TransportRequest;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.springframework.stereotype.Service;

@Service
public class WikiRoutesAdapter extends ApiCaller implements TransportProviderPort {

    private TransportRequest request;
    private static final String API_KEY = "9028a74e56mshe623399d822e356p1414a2jsn3a4dffa44e24";
    private static final String API_HOST = "wikiroutes-api.p.rapidapi.com";

    public void setRequest(TransportRequest request) {
        this.request = request;
    }

    @Override
    public void loginAPI() {
        // No specific login required for WikiRoutes API
        System.out.println("WikiRoutesAdapter: loginAPI executed.");
    }

    @Override
    public void checkToken() {
        // No token check required for WikiRoutes API
        System.out.println("WikiRoutesAdapter: checkToken executed.");
    }

    @Override
    public String callAPI() {
        if (request == null) {
            return "No request provided";
        }
        try {
            // Extract dynamic parameters from request
            String origin = request.getOrigin();
            String destination = request.getDestination();

            // Construct the URL using the dynamic parameters
            String url = "https://wikiroutes-api.p.rapidapi.com/routes?origin="
                    + origin + "&destination=" + destination
                    + "&departureTime=2025-01-20T13:01:00&arrivalTime=2025-01-20T13:01:00&transfers=1";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("x-rapidapi-key", API_KEY)
                    .header("x-rapidapi-host", API_HOST)
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred: " + e.getMessage();
        }
    }

    @Override
    public String fetchData(TransportRequest request) {
        setRequest(request);
        return makeApiCall();
    }
}
