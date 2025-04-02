package com.example.SOEX_PROJECT_JRN.ports.RestaurantPort;

import com.example.SOEX_PROJECT_JRN.ApiCaller;
import com.example.SOEX_PROJECT_JRN.domein.RestaurantDTO;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class UberEatsScraperAdapt extends ApiCaller implements IRestaurantPort{

    private static final String API_URL = "https://uber-eats-scraper-api.p.rapidapi.com/api/job/";
    private static final String API_HOST = "uber-eats-scraper-api.p.rapidapi.com";
    private static final String API_KEY = "a7b69bc686msh68ba58f492aa838p19463djsn64a146bb579d";

    String key;

    @Override
    public void loginAPI() {
    key = "a7b69bc686msh68ba58f492aa838p19463djsn64a146bb579d";
    }

    @Override
    public void checkToken() {

    }

    @Override
    public String callAPI() {
        String apiUrl = "https://uber-eats-scraper-api.p.rapidapi.com/api/job";

        HttpResponse<JsonNode> response = Unirest.post(apiUrl)
                .header("x-rapidapi-key", key)
                .header("x-rapidapi-host", "uber-eats-scraper-api.p.rapidapi.com")
                .header("Content-Type", "application/json")
                .body("{\"scraper\":{\"maxRows\":15,\"query\":\"Pizza\",\"address\":\"1600 Pennsylvania Avenue, Washington DC\",\"locale\":\"en-US\",\"page\":1}}")
                .asJson();

        String result;
        if (response.isSuccess()) {
            result = response.getBody().toString(); // Get JSON response as formatted string
        } else {
            result = "Error: " + response.getStatus() + " - " + response.getStatusText();
        }

        // Best practice: Shut down Unirest when done
        Unirest.shutDown();

        return result;

    }



    @Override
    public List<RestaurantDTO> retrieveData() {
        String response = makeApiCall();

        List<RestaurantDTO> restaurantList = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(response);
        JSONObject returnValue = jsonObject.optJSONObject("returnvalue");
        JSONArray restaurants = returnValue.optJSONArray("data");

        if (restaurants == null || restaurants.length() == 0) {
            throw new RuntimeException("Er zijn geen restaurants gevonden.");
        }

        for (int i = 0; i < restaurants.length(); i++) {
            JSONObject restaurant = restaurants.getJSONObject(i);
            JSONObject location = restaurant.getJSONObject("location");
            RestaurantDTO restaurantObject = new RestaurantDTO(restaurant.getString("title"),location.getInt("latitude"), location.getInt("longitude"), location.getString("city"), restaurant.getString("phoneNumber"));
            restaurantList.add(restaurantObject);
        }
        System.out.println(restaurantList);
        return restaurantList;
    }
}
