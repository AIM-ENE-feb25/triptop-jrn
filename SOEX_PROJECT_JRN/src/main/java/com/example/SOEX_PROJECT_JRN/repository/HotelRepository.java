package com.example.SOEX_PROJECT_JRN.repository;

import com.fasterxml.jackson.databind.JsonNode;

public interface HotelRepository {
    JsonNode getHotelsInArea(String latitude, String longitude);
}
