package com.example.SOEX_PROJECT_JRN.externalservices;

import com.example.SOEX_PROJECT_JRN.model.TransportRequest;
import com.example.SOEX_PROJECT_JRN.model.TransportResponse;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.springframework.stereotype.Service;

@Service
public class NavitimeAdapter extends ApiCaller implements TransportProviderPort {

    private final HttpClient httpClient = HttpClient.newHttpClient();
    private static final String API_KEY = "9028a74e56mshe623399d822e356p1414a2jsn3a4dffa44e24";
    private static final String API_HOST = "navitime-route-totalnavi.p.rapidapi.com";

    @Override
    public TransportResponse fetchData(TransportRequest request) {
        return callApi(request);
    }

    @Override
    protected TransportResponse apiCall(TransportRequest request) {
        try {
            // Here, the URL uses fixed parameters based on the sample code.
            String url = "https://navitime-route-totalnavi.p.rapidapi.com/route_transit?start=35.665251%2C139.712092&goal=35.661971%2C139.703795&datum=wgs84&term=1440&limit=5&start_time=2020-08-19T10%3A00%3A00&coord_unit=degree";

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
