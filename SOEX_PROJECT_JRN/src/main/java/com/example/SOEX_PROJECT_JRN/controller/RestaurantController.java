package com.example.SOEX_PROJECT_JRN.controller;

import com.example.SOEX_PROJECT_JRN.domein.RestaurantDTO;
import com.example.SOEX_PROJECT_JRN.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/getAllRestaurents")
    public List<RestaurantDTO> getAllRestaurantsInArea(){
        return restaurantService.getAllRestaurants();
    }

}
