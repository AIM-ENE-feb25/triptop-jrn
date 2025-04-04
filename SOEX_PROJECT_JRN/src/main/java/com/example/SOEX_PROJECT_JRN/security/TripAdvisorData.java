package com.example.SOEX_PROJECT_JRN.security;

public class TripAdvisorData implements SecurityData {

    private final String rapidApiKey = "c70851b4c7msh277df39776047c1p15ca0ajsnc9fc22ec0514";

    private final String[][] tripadvisorSecurity =
            {{"x-rapidapi-key", "c70851b4c7msh277df39776047c1p15ca0ajsnc9fc22ec0514"},
                    {"x-rapidapi-host", "tripadvisor16.p.rapidapi.com"}};

    public String getKey() {
        return rapidApiKey;
    }

    public String getSecurityData(int index, int index2){
        return tripadvisorSecurity[index][index2];
    }
}
