package com.example.SOEX_PROJECT_JRN.ports.RestaurantPort;

import com.example.SOEX_PROJECT_JRN.domein.RestaurantDTO;

import java.util.List;

public interface IRestaurantPort {
    public List<RestaurantDTO> retrieveData();

    //data om mee te nemen
    //naam
    //longditude, langidtude
    //city
    // soort eten/ quisine
    //voor in een dto wel heel handig

}
