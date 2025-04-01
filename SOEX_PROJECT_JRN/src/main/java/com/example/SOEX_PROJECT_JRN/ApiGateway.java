package com.example.SOEX_PROJECT_JRN;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpHeaders;

import java.util.List;

public interface ApiGateway {
    SecurityData securityData = new SecurityData();
    JsonNode getHotelsInArea(String latitude, String longitude, HttpHeaders headers);
}
