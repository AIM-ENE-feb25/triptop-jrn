package com.example.SOEX_PROJECT_JRN;

import com.example.SOEX_PROJECT_JRN.domein.RestaurantDTO;

import java.util.List;
import java.util.Map;

public abstract class ApiCaller {

    public String makeApiCall() {
        loginAPI();
        checkToken();
        String response = callAPI();
        return response;
    }

    public abstract void loginAPI();
    public abstract void checkToken();
    public abstract String callAPI();
}
