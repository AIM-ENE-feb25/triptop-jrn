package com.example.SOEX_PROJECT_JRN.service;

import com.example.SOEX_PROJECT_JRN.repository.BookingRepo;
import com.example.SOEX_PROJECT_JRN.repository.TripadvisorRepo;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    private final BookingRepo bookingRepo;
    private final TripadvisorRepo tripadvisorRepo;

    public HotelService(BookingRepo bookingRepo, TripadvisorRepo tripadvisorRepo) {
        this.bookingRepo = bookingRepo;
        this.tripadvisorRepo = tripadvisorRepo;
    }

    public List<JsonNode> getHotelsInArea(String latitude, String longitude) {

        JsonNode bookingHotels = bookingRepo.getHotelsInArea(latitude, longitude);
        JsonNode tripadvisorHotels = tripadvisorRepo.getHotelsInArea(latitude, longitude);

        return List.of(bookingHotels, tripadvisorHotels);
    }
}

