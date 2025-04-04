package com.example.SOEX_PROJECT_JRN.ports.RestaurantPort;

import com.example.SOEX_PROJECT_JRN.domein.RestaurantDTO;

import java.util.List;

public interface IRestaurantPort {
     List<RestaurantDTO> retrieveData();

}
