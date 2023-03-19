package com.bikerent.rents;

import com.bikerent.bikes.Bike;
import com.bikerent.bikes.BikeRepository;
import com.bikerent.user.User;
import com.bikerent.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class RentTest {

    private RentRepository rentRepository;
    private UserRepository userRepository;
    private BikeRepository bikeRepository;

    @Test
    void testFindRentById() {

        //Given
        User johnSmith = new User("John", "Smith", "johnsmith@test.com", 195897465);
        User kateMoods = new User("Kate", "Moods", "katemoods@test.com", 165328974);
        userRepository.save(johnSmith);
        userRepository.save(kateMoods);

        Bike racing = new Bike("racing", 19);
        Bike mtb = new Bike("MTB", 21);
        Bike trekking = new Bike("trekking", 23);
        Bike city = new Bike("city", 19);
        bikeRepository.save(racing);
        bikeRepository.save(mtb);
        bikeRepository.save(trekking);
        bikeRepository.save(city);

        Rent rent1 = new Rent(LocalDate.now(), LocalDate.now().plusDays(1), johnSmith, racing);
        Rent rent2 = new Rent(LocalDate.now(), LocalDate.now().plusDays(2), kateMoods, mtb);
        rentRepository.save(rent1);
        rentRepository.save(rent2);

        //When
        Long rent1Id = rent1.getId();
        Long rent2Id = rent2.getId();

        Optional<Rent> testRent1 = rentRepository.findById(rent1Id);
        Optional<Rent> testRent2 = rentRepository.findById(rent2Id);

        //Then
        assertEquals(rent1Id, testRent1.get().getId());
        assertEquals(rent2Id, testRent2.get().getId());

        //CleanUp
        rentRepository.deleteAll();
        userRepository.deleteAll();
        bikeRepository.deleteAll();
    }

    @Test
    void testDeleteRentById() {

        //Given
        User johnSmith = new User("John", "Smith", "johnsmith@test.com", 195897465);
        User kateMoods = new User("Kate", "Moods", "katemoods@test.com", 165328974);
        userRepository.save(johnSmith);
        userRepository.save(kateMoods);

        Bike racing = new Bike("racing", 19);
        Bike mtb = new Bike("MTB", 21);
        Bike trekking = new Bike("trekking", 23);
        Bike city = new Bike("city", 19);
        bikeRepository.save(racing);
        bikeRepository.save(mtb);
        bikeRepository.save(trekking);
        bikeRepository.save(city);

        Rent rent1 = new Rent(LocalDate.now(), LocalDate.now().plusDays(1), johnSmith, racing);
        Rent rent2 = new Rent(LocalDate.now(), LocalDate.now().plusDays(2), kateMoods, mtb);
        rentRepository.save(rent1);
        rentRepository.save(rent2);

        //When
        rentRepository.deleteById(rent2.getId());
        List<Rent> rents = (List<Rent>) rentRepository.findAll();

        //Then
        assertEquals(1, rents.size());
        assertEquals(rent1.getId(), rents.get(0).getId());

        //CleanUp
        rentRepository.deleteAll();
        userRepository.deleteAll();
        bikeRepository.deleteAll();

    }

}