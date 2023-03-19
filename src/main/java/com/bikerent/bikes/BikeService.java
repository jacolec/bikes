package com.bikerent.bikes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    public List<Bike> getAllBikes() {
        return (List<Bike>) bikeRepository.findAll();
    }

    public Bike getBike(Long bikeId) {
        return bikeRepository.findById(bikeId).get();
    }

    public Bike saveBike(final Bike bike) {
        return bikeRepository.save(bike);
    }

    public void deleteBike(Long bikeId) {
        bikeRepository.deleteById(bikeId);
    }
}
