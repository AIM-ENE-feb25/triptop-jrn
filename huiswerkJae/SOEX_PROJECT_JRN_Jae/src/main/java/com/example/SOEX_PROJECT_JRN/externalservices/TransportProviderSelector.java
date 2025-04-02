package com.example.SOEX_PROJECT_JRN.externalservices;

import com.example.SOEX_PROJECT_JRN.model.TransportRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransportProviderSelector {

    private final FakeTransportAdapter fakeTransportAdapter;
    private final WikiRoutesAdapter wikiRoutesAdapter;
    // Future adapters (GoogleMapsAdapter, NavitiaAdapter, etc.) will be put here

    @Autowired
    public TransportProviderSelector(FakeTransportAdapter fakeTransportAdapter,  WikiRoutesAdapter wikiRoutesAdapter) {
        this.fakeTransportAdapter = fakeTransportAdapter;
        this.wikiRoutesAdapter = wikiRoutesAdapter;
    }

    public TransportProviderPort selectProvider(TransportRequest request) {
        // For now, simple criteria for which adaptor is used.
        // For instance, if the origin contains "wiki", use WikiRoutesAdapter; otherwise, default to FakeTransportAdapter.
        if (request.getOrigin().toLowerCase().contains("wiki")) {
            return wikiRoutesAdapter;
        }
//        return fakeTransportAdapter;
        return wikiRoutesAdapter;
    }
}
