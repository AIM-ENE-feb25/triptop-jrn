package com.example.SOEX_PROJECT_JRN.service;

import com.example.SOEX_PROJECT_JRN.domein.RestaurantDTO;
import com.example.SOEX_PROJECT_JRN.ports.RestaurantPort.IRestaurantPort;
import com.example.SOEX_PROJECT_JRN.ports.RestaurantPort.UberEatsScraperAdapt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class RestaurantService {

    List<IRestaurantPort> restaurantPorts;
    public RestaurantService() {
        restaurantPorts.add(new UberEatsScraperAdapt());  //Reflection & introspection
    }

    public List<RestaurantDTO> getAllRestaurants() {
        List<RestaurantDTO> returnList = new ArrayList<RestaurantDTO>(); //set implementation (mogelijk hashSet) javaDoc java set
        for(IRestaurantPort restaurant : restaurantPorts){
            returnList.addAll(restaurant.retrieveData());
        }
        return returnList;
    }
}
