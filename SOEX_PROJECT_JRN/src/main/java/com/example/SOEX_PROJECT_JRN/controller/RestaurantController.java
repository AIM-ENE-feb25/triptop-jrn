package com.example.SOEX_PROJECT_JRN.controller;

import com.example.SOEX_PROJECT_JRN.domein.RestaurantDTO;
import com.example.SOEX_PROJECT_JRN.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/getAllRestaurents")
    public List<RestaurantDTO> getAllRestaurantsInArea(){
        return restaurantService.getAllRestaurants();
    }
}
