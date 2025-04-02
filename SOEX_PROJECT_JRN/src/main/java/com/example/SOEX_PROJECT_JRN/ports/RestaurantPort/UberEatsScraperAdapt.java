package com.example.SOEX_PROJECT_JRN.ports.RestaurantPort;

import com.example.SOEX_PROJECT_JRN.ApiCaller;
import com.example.SOEX_PROJECT_JRN.domein.RestaurantDTO;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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

        // Call the API to get the response
        String response = makeApiCall();
        System.out.println("Response: " + response);

        try {
            // Convert the response to a JSON object for easier parsing
            JsonNode jsonNode = new JsonNode(response);

            // Access the data array inside the 'returnvalue' key
            JsonNode restaurantsData = jsonNode.getObject().get("returnvalue").getObject().get("data");

            // Iterate through the array of restaurant data
            for (JsonNode restaurantNode : restaurantsData) {
                String title = restaurantNode.getObject().get("title").asText();  // Get the title
                List<String> cuisineList = new ArrayList<>();

                // Extract the cuisine list
                JsonNode cuisinesNode = restaurantNode.getObject().get("cuisineList");
                for (JsonNode cuisine : cuisinesNode) {
                    cuisineList.add(cuisine.asText());
                }

                // Extract latitude and longitude
                double latitude = restaurantNode.getObject().get("location").getObject().get("latitude").asDouble();
                double longitude = restaurantNode.getObject().get("location").getObject().get("longitude").asDouble();

                // Create a RestaurantDTO object with the extracted data
                RestaurantDTO restaurantDTO = new RestaurantDTO(title, cuisineList, latitude, longitude);
                responseList.add(restaurantDTO);
            }
        } catch (Exception e) {
            System.out.println("Error parsing API response: " + e.getMessage());
        }

        return responseList;
    }

}
