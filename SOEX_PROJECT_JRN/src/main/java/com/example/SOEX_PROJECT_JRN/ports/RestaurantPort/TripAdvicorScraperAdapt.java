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

@Component
public class TripAdvicorScraperAdapt extends ApiCaller implements IRestaurantPort{

    private static final String API_URL = "https://real-time-tripadvisor-scraper-api.p.rapidapi.com/tripadvisor_restaurants_search_v2?location=new%20york";
    private static final String API_HOST = "real-time-tripadvisor-scraper-api.p.rapidapi.com";
    private static final String API_KEY = "a7b69bc686msh68ba58f492aa838p19463djsn64a146bb579d";

    String key;

    @Override
    public void loginAPI() {
        key = API_KEY;
    }

    @Override
    public void checkToken() {

    }

    @Override
    public String callAPI() {

        HttpResponse<JsonNode> response = Unirest.get(API_URL)
                .header("x-rapidapi-key", key)
                .header("x-rapidapi-host", API_HOST)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
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
        JSONArray jsonArray = jsonObject.getJSONArray("data");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject restaurant = jsonArray.getJSONObject(i);
            JSONObject address = restaurant.getJSONObject("address");
            RestaurantDTO restaurantObject = new RestaurantDTO(restaurant.getString("name"), address.getInt("latitude"),  address.getInt("longitude"), address.getString("fullAddress"), restaurant.getString("telephone"));
            restaurantList.add(restaurantObject);
        }

        return restaurantList;

    }
}
