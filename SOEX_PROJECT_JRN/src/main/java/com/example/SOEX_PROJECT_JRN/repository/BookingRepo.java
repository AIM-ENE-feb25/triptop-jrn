package com.example.SOEX_PROJECT_JRN.repository;

import com.example.SOEX_PROJECT_JRN.SecurityData;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Repository
public class BookingRepo implements HotelRepository {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String BASE_URL = "https://booking-com.p.rapidapi.com/v1/hotels/search-by-coordinates";

    @Override
    public JsonNode getHotelsInArea(String latitude, String longitude, HttpHeaders headers) {

        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .queryParam("children_ages", "5,0")
                .queryParam("include_adjacency", "true")
                .queryParam("adults_number", "2")
                .queryParam("checkout_date", "2025-09-26")
                .queryParam("filter_by_currency", "AED")
                .queryParam("checkin_date", "2025-09-25")
                .queryParam("categories_filter_ids", "class::2,class::4,free_cancellation::1")
                .queryParam("units", "metric")
                .queryParam("order_by", "popularity")
                .queryParam("children_number", "2")
                .queryParam("locale", "en-gb")
                .queryParam("page_number", "0")
                .queryParam("room_number", "1")
                .queryParam("latitude", latitude)
                .queryParam("longitude", longitude)
                .encode()
                .toUriString();

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        headers.set(securityData.getBookingData(0, 0), securityData.getBookingData(0, 1));
        headers.set(securityData.getBookingData(1, 0), securityData.getBookingData(1, 1));

        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, JsonNode.class);

        JsonNode resultArray = response.getBody().get("result");

        if (resultArray != null && resultArray.isArray() && resultArray.size() > 0) {
            JsonNode firstHotel = resultArray.get(0);
            JsonNode hotelNameNode = firstHotel.get("hotel_name_trans");

            if (hotelNameNode != null) {
                System.out.println("Booking com request complete");
                return hotelNameNode;
            }
        }

        System.out.println("Booking com request complete");

        return response.getBody();
    }
}
