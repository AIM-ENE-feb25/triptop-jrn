package com.example.SOEX_PROJECT_JRN.service;

import com.example.SOEX_PROJECT_JRN.externalservices.TransportProviderSelector;
import com.example.SOEX_PROJECT_JRN.externalservices.TransportProviderPort;
import com.example.SOEX_PROJECT_JRN.model.TransportRequest;
import com.example.SOEX_PROJECT_JRN.model.TransportResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransportService {

    private final TransportProviderSelector providerSelector;

    @Autowired
    public TransportService(TransportProviderSelector providerSelector) {
        this.providerSelector = providerSelector;
    }

    public TransportResponse getTransportData(TransportRequest request) {
        TransportProviderPort provider = providerSelector.selectProvider(request);
        String responseString = provider.fetchData(request);
        return new TransportResponse(responseString);
    }
}
