package com.example.SOEX_PROJECT_JRN.externalservices;

import com.example.SOEX_PROJECT_JRN.model.TransportRequest;
import com.example.SOEX_PROJECT_JRN.model.TransportResponse;

public abstract class ApiCaller {

    public TransportResponse callApi(TransportRequest request) {
        login();
        checkToken();
        return apiCall(request);
    }

    protected abstract TransportResponse apiCall(TransportRequest request);

    private void login() {
        // Common login logic if required
    }

    private void checkToken() {
        // Common token checking logic if required
    }
}
