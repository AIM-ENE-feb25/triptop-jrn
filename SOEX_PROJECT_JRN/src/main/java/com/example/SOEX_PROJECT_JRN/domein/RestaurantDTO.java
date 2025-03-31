package com.example.SOEX_PROJECT_JRN.domein;

import java.util.List;

public record RestaurantDTO(String restaurant_name,
        double latitude,
        double longitude,
        String cityName,
        List<String> cuisine
) {

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getCityName() {
        return cityName;
    }

    public List<String> getCuisine() {
        return cuisine;
    }
}
