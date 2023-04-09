package com.bikerent.bikes;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BikeMapperTest {

    private BikeMapper bikeMapper;

    @Test
    void testMapToBikeDto() {
        //Given
        Bike bike = new Bike(1L, "racing", 21);
        BikeDto bikeDto = new BikeDto(1L, "racing", 21);
        //When
        BikeDto testBikeDto = bikeMapper.mapToBikeDto(bike);
        //Then
        assertEquals(bikeDto.getId(), testBikeDto.getId());
        assertEquals(bikeDto.getType(), testBikeDto.getType());
        assertEquals(bikeDto.getSize(), testBikeDto.getSize());
    }

    @Test
    void testMapToBike() {
        //Given
        Bike bike = new Bike(1L, "racing", 21);
        BikeDto bikeDto = new BikeDto(1L, "racing", 21);
        //When
        Bike testBike = bikeMapper.mapToBike(bikeDto);
        //Then
        assertEquals(bike.getId(), testBike.getId());
        assertEquals(bike.getType(), testBike.getType());
        assertEquals(bike.getSize(), testBike.getSize());
    }

    @Test
    void testMapToBikeListDto() {
        //Given
        Bike racing = new Bike(1L, "racing", 21);
        Bike mtb = new Bike(2L, "mtb", 19);
        List<Bike> bikes = new ArrayList<>();
        bikes.add(racing);
        bikes.add(mtb);

        BikeDto racingDto = new BikeDto(1L, "racing", 21);
        BikeDto mtbDto = new BikeDto(2L, "mtb", 19);
        List<BikeDto> bikeDtos = new ArrayList<>();
        bikeDtos.add(racingDto);
        bikeDtos.add(mtbDto);

        //When
        List<BikeDto> testBikeDtoList = bikeMapper.mapToBikeListDto(bikes);

        //Then
        assertEquals(bikeDtos.get(0), testBikeDtoList.get(0));
        assertEquals(bikeDtos.get(1), testBikeDtoList.get(1));
        assertEquals(bikeDtos.size(), testBikeDtoList.size());
    }

}