package com.example.SOEX_PROJECT_JRN.repository;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpHeaders;

public interface HotelRepository {
    JsonNode getHotelsInArea(String latitude, String longitude, HttpHeaders headers);
}
