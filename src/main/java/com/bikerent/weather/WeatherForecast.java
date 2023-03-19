package com.bikerent.weather;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class WeatherForecast {

    private String station;
    private String date;
    private String temperature;
    private String pressure;
    private String wind;
    private String precipitation;
}
