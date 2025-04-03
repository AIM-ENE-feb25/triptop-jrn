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
        String provider = request.getProvider();
        if (provider != null) {
            switch (provider.toUpperCase()) {
                case "WIKIROUTES":
                    return wikiRoutesAdapter;
                case "NAVITIME":
                    return navitimeAdapter;
                case "BUSMAPS":
                    return busMapsAdapter;
                case "FAKE":
                default:
                    return fakeTransportAdapter;
            }
        }
        return fakeTransportAdapter;
    }
}
