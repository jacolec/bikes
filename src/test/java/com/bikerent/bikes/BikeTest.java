package com.bikerent.bikes;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BikeTest {

    private BikeRepository bikeRepository;

    @Test
    void testFindBikeById() {

        //Given
        Bike racing = new Bike("racing", 19);
        Bike mtb = new Bike("MTB", 21);
        Bike trekking = new Bike("trekking", 23);
        Bike city = new Bike("city", 19);

        bikeRepository.save(racing);
        bikeRepository.save(mtb);
        bikeRepository.save(trekking);
        bikeRepository.save(city);

        //When
        Long racingId = racing.getId();
        Long mtbId = mtb.getId();
        Long trekkingId = trekking.getId();
        Long cityId = city.getId();

        Optional<Bike> testBike1 = bikeRepository.findById(racingId);
        Optional<Bike> testBike2 = bikeRepository.findById(mtbId);
        Optional<Bike> testBike3 = bikeRepository.findById(trekkingId);
        Optional<Bike> testBike4 = bikeRepository.findById(cityId);

        //Then
        assertEquals(racingId, testBike1.get().getId());
        assertEquals(mtbId, testBike2.get().getId());
        assertEquals(trekkingId, testBike3.get().getId());
        assertEquals(cityId, testBike4.get().getId());

        //CleanUp
        bikeRepository.deleteAll();
    }

    @Test
    void testDeleteBikeById() {

        //Given
        Bike racing = new Bike("racing", 19);
        Bike mtb = new Bike("MTB", 21);
        Bike trekking = new Bike("trekking", 23);
        Bike city = new Bike("city", 19);

        bikeRepository.save(racing);
        bikeRepository.save(mtb);
        bikeRepository.save(trekking);
        bikeRepository.save(city);

        //When
        bikeRepository.deleteById(trekking.getId());
        bikeRepository.deleteById(city.getId());

        List<Bike> bikes = (List<Bike>) bikeRepository.findAll();

        //Then
        assertEquals(2, bikes.size());
        assertEquals(racing.getId(), bikes.get(0).getId());
        assertEquals(mtb.getId(), bikes.get(1).getId());

        //CleanUp
        bikeRepository.deleteAll();
    }





}