package com.example.SOEX_PROJECT_JRN.externalservices;

import com.example.SOEX_PROJECT_JRN.model.TransportRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransportProviderSelector {

    private final FakeTransportAdapter fakeTransportAdapter;
    // Future adapters (GoogleMapsAdapter, NavitiaAdapter, etc.) will be put here

    @Autowired
    public TransportProviderSelector(FakeTransportAdapter fakeTransportAdapter) {
        this.fakeTransportAdapter = fakeTransportAdapter;
    }

    public TransportProviderPort selectProvider(TransportRequest request) {
        // Selection logic can be extended here.
        // For now, we default to the fake adapter.
        return fakeTransportAdapter;
    }
}
