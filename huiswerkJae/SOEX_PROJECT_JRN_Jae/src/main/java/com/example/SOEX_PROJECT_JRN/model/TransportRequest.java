package com.example.SOEX_PROJECT_JRN.model;

public class TransportRequest {
    private String origin;
    private String destination;

    public TransportRequest() {}

    public TransportRequest(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
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
}
