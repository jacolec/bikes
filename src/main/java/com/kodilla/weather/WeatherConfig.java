package com.kodilla.weather;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class WeatherConfig {

    @Value("https://danepubliczne.imgw.pl/api/data/synop/id/")
    private String weatherApiEndPoint;

    @Value("123675")
    private String weatherStationId;
}
