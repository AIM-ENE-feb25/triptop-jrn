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
public class UberEatsScraperAdapt extends ApiCaller implements IRestaurantPort{

    private static final String API_URL = "https://uber-eats-scraper-api.p.rapidapi.com/api/job/";
    private static final String API_HOST = "uber-eats-scraper-api.p.rapidapi.com";
    private static final String API_KEY = "f59f41d84amsh9e1aa2f556b69f5p1c6b08jsnc559d2c68cc7";

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

        HttpResponse<JsonNode> response = Unirest.post(API_URL)
                .header("x-rapidapi-key", key)
                .header("x-rapidapi-host", API_HOST)
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
//        return null;
    }



    @Override
    public List<RestaurantDTO> retrieveData() {
//        List<RestaurantDTO> testList = new ArrayList<>();
//        RestaurantDTO testDTO = new RestaurantDTO("Roko's bbq", 48.8566, 2.3522, "Onder de eifeltoren 23, Parijs", "+11 9654721");
//        testList.add(testDTO);
        String response = makeApiCall();

        List<RestaurantDTO> restaurantList = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(response);
        JSONObject returnValue = jsonObject.optJSONObject("returnvalue");
        JSONArray restaurants = returnValue.optJSONArray("data");

        for (int i = 0; i < restaurants.length(); i++) {
            JSONObject restaurant = restaurants.getJSONObject(i);
            JSONObject location = restaurant.getJSONObject("location");
            RestaurantDTO restaurantObject = new RestaurantDTO(restaurant.getString("title"),location.getInt("latitude"), location.getInt("longitude"), location.getString("address"), restaurant.getString("phoneNumber"));
            restaurantList.add(restaurantObject);
        }
        return restaurantList;
//        return testList;
    }
}
