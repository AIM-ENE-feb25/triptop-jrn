package com.example.SOEX_PROJECT_JRN.ports.transportPort;

import com.example.SOEX_PROJECT_JRN.ApiCaller;
import com.example.SOEX_PROJECT_JRN.domein.TransportRequest;
import com.example.SOEX_PROJECT_JRN.domein.TransportResponse;
import org.springframework.stereotype.Service;

@Service
public class FakeTransportAdapter extends ApiCaller implements TransportProviderPort {

    private TransportRequest request;

    public void setRequest(TransportRequest request) {
        this.request = request;
    }

    @Override
    public void loginAPI() {
        System.out.println("FakeTransportAdapter: loginAPI executed.");
    }

    @Override
    public void checkToken() {
        System.out.println("FakeTransportAdapter: checkToken executed.");
    }

    @Override
    public String callAPI() {
        if (request != null) {
            return "Fake transport data for " + request.getOrigin() + " to " + request.getDestination();
        }
        return "No request provided";
    }

    @Override
    public TransportResponse fetchData(TransportRequest request) {
        setRequest(request);
        String responseString = makeApiCall();
        return new TransportResponse(responseString);
    }
}
