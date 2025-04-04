package com.example.SOEX_PROJECT_JRN.ports.transportPort;

import com.example.SOEX_PROJECT_JRN.domein.TransportRequest;
import com.example.SOEX_PROJECT_JRN.domein.TransportResponse;

public interface TransportProviderPort {
    TransportResponse fetchData(TransportRequest request);
}
