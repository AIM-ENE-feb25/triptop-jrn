package com.example.SOEX_PROJECT_JRN.domein;

import java.util.List;

public record RestaurantDTO(String restaurant_name,
        double latitude,
        double longitude,
        String address,
        String getPhoneNumber
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

    public String address() {
        return address;
    }

    public String getPhoneNumber() {
        return getPhoneNumber;
    }
}
