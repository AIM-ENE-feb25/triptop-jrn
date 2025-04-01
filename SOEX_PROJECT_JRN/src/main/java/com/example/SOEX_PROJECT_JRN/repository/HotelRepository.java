package com.example.SOEX_PROJECT_JRN.repository;

import com.example.SOEX_PROJECT_JRN.SecurityData;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpHeaders;

public interface HotelRepository {

    final SecurityData securityData = new SecurityData();
    JsonNode getHotelsInArea(String latitude, String longitude, HttpHeaders headers);
}
