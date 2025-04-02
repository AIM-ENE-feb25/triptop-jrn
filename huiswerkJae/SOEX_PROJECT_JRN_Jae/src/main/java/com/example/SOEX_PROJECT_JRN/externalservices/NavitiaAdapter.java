package com.example.SOEX_PROJECT_JRN.externalservices;

import com.example.SOEX_PROJECT_JRN.model.TransportRequest;
import com.example.SOEX_PROJECT_JRN.model.TransportResponse;
import org.springframework.stereotype.Service;

@Service
public class NavitiaAdapter extends ApiCaller implements TransportProviderPort {

    @Override
    public TransportResponse fetchData(TransportRequest request) {
        return callApi(request);
    }

    @Override
    protected TransportResponse apiCall(TransportRequest request) {
        // Simulate API call for Navitia
        return new TransportResponse("Navitia data for " + request.getOrigin() + " to " + request.getDestination());
    }
}
