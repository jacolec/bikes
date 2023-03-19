package com.bikerent.weather;

import org.springframework.stereotype.Component;

@Component
public class WeatherMapper {

    public WeatherForecastDto mapToWeatherForecastDto(WeatherForecast weatherForecast) {
        return new WeatherForecastDto(weatherForecast.getStation(),
                weatherForecast.getDate(),
                weatherForecast.getTemperature(),
                weatherForecast.getPressure(),
                weatherForecast.getWind(),
                weatherForecast.getPrecipitation());
    }

    public WeatherForecast mapToWeatherForecast(WeatherForecastDto weatherForecastDto) {
        return new WeatherForecast(weatherForecastDto.getStation(),
                weatherForecastDto.getDate(),
                weatherForecastDto.getTemperature(),
                weatherForecastDto.getPressure(),
                weatherForecastDto.getWind(),
                weatherForecastDto.getPrecipitation());
    }
}
