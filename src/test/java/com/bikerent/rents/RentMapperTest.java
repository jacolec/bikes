package com.bikerent.rents;

import com.bikerent.bikes.Bike;
import com.bikerent.user.User;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class RentMapperTest {

    private RentMapper rentMapper;

    @Test
    void testMapToRentDto() {
        //Given
        User johnSmith = new User("John", "Smith", "johnsmith@test.com", 195897465);
        Bike racing = new Bike("racing", 19);
        Rent rent = new Rent(1L, LocalDate.now(), LocalDate.now().plusDays(3), johnSmith, racing);
        //When
        RentDto rentDto = rentMapper.mapToRentDto(rent);
        //Then
        assertEquals(rent.getId(), rentDto.getId());
        assertEquals(rent.getDateOfRent(), rentDto.getDateOfRent());
        assertEquals(rent.getDateOfReturn(), rentDto.getDateOfReturn());
        assertEquals(rent.getUser().getId(), rentDto.getUserId());
        assertEquals(rent.getBike().getId(), rentDto.getBikeId());
    }

    @Test
    void testMapToRent() {
        //Given
        User johnSmith = new User("John", "Smith", "johnsmith@test.com", 195897465);
        Bike racing = new Bike("racing", 19);
        RentDto rentDto = new RentDto(1L, LocalDate.now(), LocalDate.now().plusDays(3), johnSmith.getId(), racing.getId());
        //When
        Rent testRent = rentMapper.mapToRent(rentDto);
        //Then
        assertEquals(rentDto.getId(), testRent.getId());
        assertEquals(rentDto.getDateOfRent(), testRent.getDateOfRent());
        assertEquals(rentDto.getDateOfReturn(), testRent.getDateOfReturn());
        assertEquals(rentDto.getUserId(), testRent.getUser().getId());
        assertEquals(rentDto.getBikeId(), testRent.getBike().getId());
    }

    @Test
    void testMapToRentListDto() {
        //Given
        User johnSmith = new User("John", "Smith", "johnsmith@test.com", 195897465);
        User kateMoods = new User("Kate", "Moods", "katemoods@test.com", 165328974);
        Bike racing = new Bike("racing", 19);
        Bike mtb = new Bike("MTB", 21);
        Rent rent1 = new Rent(1L, LocalDate.now(), LocalDate.now().plusDays(3), johnSmith, racing);
        Rent rent2 = new Rent(2L, LocalDate.now(), LocalDate.now().plusDays(5), kateMoods, mtb);
        List<Rent> rents = new ArrayList<>();
        rents.add(rent1);
        rents.add(rent2);

        RentDto rentDto1 = new RentDto(1L, LocalDate.now(), LocalDate.now().plusDays(3), johnSmith.getId(), racing.getId());
        RentDto rentDto2 = new RentDto(L, LocalDate.now(), LocalDate.now().plusDays(5), kateMoods.getId(), mtb.getId());
        List<RentDto> rentDtos = new ArrayList<>();
        rentDtos.add(rentDto1);
        rentDtos.add(rentDto2);

        //When
        List<RentDto> testList = rentMapper.mapToRentListDto(rents);

        //Then
        assertEquals(testList.get(0), rentDtos.get(0));
        assertEquals(testList.get(1), rentDtos.get(1));
        assertEquals(testList.size(), rentDtos.size());
    }
}