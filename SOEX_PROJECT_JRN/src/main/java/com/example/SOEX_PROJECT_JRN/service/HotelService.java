package com.example.SOEX_PROJECT_JRN.service;

import com.example.SOEX_PROJECT_JRN.repository.BookingRepo;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    private final BookingRepo repo;
    public HotelService(BookingRepo repo) {
        this.repo = repo;
    }

    public JsonNode getHotelsInArea(String latitude, String longitude) {
        return repo.getHotelsInArea(latitude, longitude, new HttpHeaders());
    }
}
