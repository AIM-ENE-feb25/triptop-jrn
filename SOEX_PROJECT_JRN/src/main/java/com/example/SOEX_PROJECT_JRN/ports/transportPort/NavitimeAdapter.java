package com.example.SOEX_PROJECT_JRN.externalservices;

import com.example.SOEX_PROJECT_JRN.ApiCaller;
import com.example.SOEX_PROJECT_JRN.model.TransportRequest;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.springframework.stereotype.Service;

@Service
public class NavitimeAdapter extends ApiCaller implements TransportProviderPort {

    private TransportRequest request;
    private static final String API_KEY = "9028a74e56mshe623399d822e356p1414a2jsn3a4dffa44e24";
    private static final String API_HOST = "navitime-route-totalnavi.p.rapidapi.com";

    public void setRequest(TransportRequest request) {
        this.request = request;
    }

    @Override
    public void loginAPI() {
        System.out.println("NavitimeAdapter: loginAPI executed.");
    }

    @Override
    public void checkToken() {
        System.out.println("NavitimeAdapter: checkToken executed.");
    }

    @Override
    public String callAPI() {
        if (request == null) {
            return "No request provided";
        }
        try {
            String origin = request.getOrigin();       // Expected format: "35.665251,139.712092"
            String destination = request.getDestination(); // Expected format: "35.661971,139.703795"

            // Construct URL dynamically using request parameters
            String url = "https://navitime-route-totalnavi.p.rapidapi.com/route_transit?start="
                    + origin + "&goal=" + destination
                    + "&datum=wgs84&term=1440&limit=5&start_time=2020-08-19T10:00:00&coord_unit=degree";

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
