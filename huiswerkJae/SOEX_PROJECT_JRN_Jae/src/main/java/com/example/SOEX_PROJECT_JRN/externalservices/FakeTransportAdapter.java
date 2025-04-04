package com.example.SOEX_PROJECT_JRN.externalservices;

import com.example.SOEX_PROJECT_JRN.model.TransportRequest;
import com.example.SOEX_PROJECT_JRN.model.TransportResponse;
import org.springframework.stereotype.Service;

@Service
public class FakeTransportAdapter extends ApiCaller implements TransportProviderPort {

    @Override
    public TransportResponse fetchData(TransportRequest request) {
        // Delegate to the template method 'callApi'
        return callApi(request);
    }

    @Override
    protected TransportResponse apiCall(TransportRequest request) {
        // Simulate processing time, logging, or any other logic
        String fakeData = "Fake transport data for " + request.getOrigin() + " to " + request.getDestination();
        // Return the simulated response
        return new TransportResponse(fakeData);
    }
}
