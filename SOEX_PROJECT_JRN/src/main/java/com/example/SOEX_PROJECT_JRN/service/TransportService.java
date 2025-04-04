package com.example.SOEX_PROJECT_JRN.service;

import com.example.SOEX_PROJECT_JRN.ports.transportPort.TransportProviderSelector;
import com.example.SOEX_PROJECT_JRN.ports.transportPort.TransportProviderPort;
import com.example.SOEX_PROJECT_JRN.domein.TransportRequest;
import com.example.SOEX_PROJECT_JRN.domein.TransportResponse;
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
        return provider.fetchData(request);
    }
}
