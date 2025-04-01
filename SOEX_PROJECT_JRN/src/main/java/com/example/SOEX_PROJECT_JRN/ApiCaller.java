package com.example.SOEX_PROJECT_JRN;

public abstract class ApiCaller {

    public String makeApiCall() {
        loginAPI();
        String response = callAPI();
        checkToken();
        return response;
    }

    public abstract void loginAPI();
    public abstract String callAPI();
    public abstract void checkToken();
}
