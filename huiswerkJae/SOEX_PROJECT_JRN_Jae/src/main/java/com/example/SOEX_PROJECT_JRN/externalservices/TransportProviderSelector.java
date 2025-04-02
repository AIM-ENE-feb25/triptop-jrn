package com.example.SOEX_PROJECT_JRN.externalservices;

import com.example.SOEX_PROJECT_JRN.model.TransportRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransportProviderSelector {

    private final NavitiaAdapter navitiaAdapter;
    private final GoogleMapsAdapter googleMapsAdapter;
    private final SkyscannerAdapter skyscannerAdapter;

    @Autowired
    public TransportProviderSelector(NavitiaAdapter navitiaAdapter,
                                     GoogleMapsAdapter googleMapsAdapter,
                                     SkyscannerAdapter skyscannerAdapter) {
        this.navitiaAdapter = navitiaAdapter;
        this.googleMapsAdapter = googleMapsAdapter;
        this.skyscannerAdapter = skyscannerAdapter;
    }

    public TransportProviderPort selectProvider(TransportRequest request) {
        // Logic to choose provider; here we default to GoogleMapsAdapter for demonstration
        return googleMapsAdapter;
    }
}
