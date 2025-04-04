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
        TransportProviderPort selected;
        if (provider != null) {
            switch (provider.toUpperCase()) {
                case "WIKIROUTES":
                    selected = wikiRoutesAdapter;
                    break;
                case "NAVITIME":
                    selected = navitimeAdapter;
                    break;
                case "BUSMAPS":
                    selected = busMapsAdapter;
                    break;
                case "FAKE":
                default:
                    selected = fakeTransportAdapter;
                    break;
            }
        } else {
            selected = fakeTransportAdapter;
        }
        // Set the request on the selected adapter
        if (selected instanceof FakeTransportAdapter) {
            ((FakeTransportAdapter) selected).setRequest(request);
        } else if (selected instanceof WikiRoutesAdapter) {
            ((WikiRoutesAdapter) selected).setRequest(request);
        } else if (selected instanceof NavitimeAdapter) {
            ((NavitimeAdapter) selected).setRequest(request);
        } else if (selected instanceof BusMapsAdapter) {
            ((BusMapsAdapter) selected).setRequest(request);
        }
        return selected;
    }
}
