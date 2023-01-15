package com.kodilla.bikes;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class BikeMapper {

    public BikeDto mapToBikeDto(Bike bike) {
        return new BikeDto(bike.getId(), bike.getType(), bike.getSize());
    }

    public Bike mapToBike(BikeDto bikeDto) {
        return new Bike(bikeDto.getType(), bikeDto.getSize());
    }
}
