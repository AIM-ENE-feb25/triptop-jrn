package com.example.SOEX_PROJECT_JRN.security;

public class BookingData implements SecurityData {

    private final String rapidApiKey = "c70851b4c7msh277df39776047c1p15ca0ajsnc9fc22ec0514";

    private final String[][] bookingSecurity =
            {{"x-rapidapi-key", "c70851b4c7msh277df39776047c1p15ca0ajsnc9fc22ec0514"},
                    {"x-rapidapi-host", "booking-com.p.rapidapi.com"}};

    public String getKey() {
        return rapidApiKey;
    }

    @Override
    public String getSecurityData(int index, int index2){
        return bookingSecurity[index][index2];
    }

}
