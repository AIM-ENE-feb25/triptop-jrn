package com.example.SOEX_PROJECT_JRN.ports.RestaurantPort;

import com.example.SOEX_PROJECT_JRN.ApiCaller;
import com.example.SOEX_PROJECT_JRN.domein.RestaurantDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class UberEatsScraperAdapt extends ApiCaller implements IRestaurantPort{

    private static final String API_URL = "https://uber-eats-scraper-api.p.rapidapi.com/api/job/";
    private static final String API_HOST = "uber-eats-scraper-api.p.rapidapi.com";
    private static final String API_KEY = "a7b69bc686msh68ba58f492aa838p19463djsn64a146bb579d";

    @Override
    public void loginAPI() {

    }

    @Override
    public String callAPI() {
        String apiUrl = "https://uber-eats-scraper-api.p.rapidapi.com/api/job";

        HttpResponse<JsonNode> response = Unirest.post(apiUrl)
                .header("x-rapidapi-key", "a7b69bc686msh68ba58f492aa838p19463djsn64a146bb579d")
                .header("x-rapidapi-host", "uber-eats-scraper-api.p.rapidapi.com")
                .header("Content-Type", "application/json")
                .body("{\"scraper\":{\"maxRows\":15,\"query\":\"Pizza\",\"address\":\"1600 Pennsylvania Avenue, Washington DC\",\"locale\":\"en-US\",\"page\":1}}")
                .asJson();

        String result;
        if (response.isSuccess()) {
            result = response.getBody().toPrettyString(); // Get JSON response as formatted string
        } else {
            result = "Error: " + response.getStatus() + " - " + response.getStatusText();
        }

        // Best practice: Shut down Unirest when done
        Unirest.shutDown();

        return result;

    }


    @Override
    public void checkToken() {

    }

    @Override
    public List<RestaurantDTO> retrieveData() {
        List<RestaurantDTO> responseList = new ArrayList<>();

        String response = makeApiCall();
        System.out.println("Response: " + response);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<RestaurantDTO> restaurants = Arrays.asList(objectMapper.readValue(response, RestaurantDTO[].class));

            responseList.addAll(restaurants);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseList;
    }
}
