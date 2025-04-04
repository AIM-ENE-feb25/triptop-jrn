package com.example.SOEX_PROJECT_JRN.model;

public class TransportRequest {
    private String origin;
    private String destination;
    private String provider; // e.g., "FAKE", "WIKIROUTES", "NAVITIME", "BUSMAPS"

    public TransportRequest() {}

    public TransportRequest(String origin, String destination, String provider) {
        this.origin = origin;
        this.destination = destination;
        this.provider = provider;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
