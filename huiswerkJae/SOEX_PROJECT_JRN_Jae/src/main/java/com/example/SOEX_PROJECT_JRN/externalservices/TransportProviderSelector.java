package com.example.SOEX_PROJECT_JRN.externalservices;

import com.example.SOEX_PROJECT_JRN.model.TransportRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransportProviderSelector {

    private final FakeTransportAdapter fakeTransportAdapter;
    private final WikiRoutesAdapter wikiRoutesAdapter;
    private final NavitimeAdapter navitimeAdapter;
    private final BusMapsAdapter busMapsAdapter;

    @Autowired
    public TransportProviderSelector(FakeTransportAdapter fakeTransportAdapter,
                                     WikiRoutesAdapter wikiRoutesAdapter,
                                     NavitimeAdapter navitimeAdapter,
                                     BusMapsAdapter busMapsAdapter) {
        this.fakeTransportAdapter = fakeTransportAdapter;
        this.wikiRoutesAdapter = wikiRoutesAdapter;
        this.navitimeAdapter = navitimeAdapter;
        this.busMapsAdapter = busMapsAdapter;
    }

    public TransportProviderPort selectProvider(TransportRequest request) {
        // Example selection logic based on request properties.
        // For now, you can choose a default provider or use custom logic.
        // This sample always returns the FakeTransportAdapter.
        //return fakeTransportAdapter;
        //return wikiRoutesAdapter;
        //return navitimeAdapter;
        return busMapsAdapter;
        // To use, say, the NavitimeAdapter, return navitimeAdapter instead.
    }
}
