package com.example.SOEX_PROJECT_JRN;

public abstract class ApiCaller {

    public void makeApiCall() {
        loginAPI();
        callAPI();
        checkToken();
    }

    public abstract void loginAPI();
    public abstract void callAPI();
    public abstract void checkToken();
}
