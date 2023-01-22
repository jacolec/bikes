package com.kodilla.bikes;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BikeMapper {

    public BikeDto mapToBikeDto(Bike bike) {
        return new BikeDto(bike.getId(), bike.getType(), bike.getSize());
    }

    public Bike mapToBike(BikeDto bikeDto) {
        return new Bike(bikeDto.getType(), bikeDto.getSize());
    }

    public List<BikeDto> mapToBikeListDto(final List<Bike> bikes) {
        return bikes.stream()
                .map(this::mapToBikeDto)
                .collect(Collectors.toList());
    }
}
