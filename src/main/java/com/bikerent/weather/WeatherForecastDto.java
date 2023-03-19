package com.bikerent.weather;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WeatherForecastDto {

    private String station;
    private String date;
    private String temperature;
    private String pressure;
    private String wind;
    private String precipitation;
}
