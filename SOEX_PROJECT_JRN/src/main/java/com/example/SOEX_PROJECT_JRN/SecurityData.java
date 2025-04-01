package com.example.SOEX_PROJECT_JRN;

public class SecurityData {
    private final String[][] bookingSecurity =
            {{"x-rapidapi-key", "c70851b4c7msh277df39776047c1p15ca0ajsnc9fc22ec0514"},
            {"x-rapidapi-host", "booking-com.p.rapidapi.com"}};

    private final String[][] tripadvisorSecurity =
            {{"x-rapidapi-key", "c70851b4c7msh277df39776047c1p15ca0ajsnc9fc22ec0514"},
                    {"x-rapidapi-host", "tripadvisor16.p.rapidapi.com"}};
    private final String rapidApiKey = "c70851b4c7msh277df39776047c1p15ca0ajsnc9fc22ec0514";

    public String getRapidApiKey() {
        return rapidApiKey;
    }

    public String getBookingData(int index, int index2){
        return bookingSecurity[index][index2];
    }

    public String getTripadvisorData(int index, int index2){
        return tripadvisorSecurity[index][index2];
    }
}
