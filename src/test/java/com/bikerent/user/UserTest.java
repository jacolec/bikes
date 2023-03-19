package com.bikerent.user;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserTest {

    private UserRepository userRepository;

    @Test
    void testFindUserById() {

        //Given
        User johnSmith = new User("John", "Smith", "johnsmith@test.com", 195897465);
        User kateMoods = new User("Kate", "Moods", "katemoods@test.com", 165328974);

        userRepository.save(johnSmith);
        userRepository.save(kateMoods);

        //When
        Long johnSmithId = johnSmith.getId();
        Long kateMoodsId = kateMoods.getId();

        Optional<User> testUser1 = userRepository.findById(johnSmithId);
        Optional<User> testUser2 = userRepository.findById(kateMoodsId);

        //Then
        assertEquals(johnSmithId, testUser1.get().getId());
        assertEquals(kateMoodsId, testUser2.get().getId());

        //CleanUp
        userRepository.deleteAll();
    }

    @Test
    void testDeleteUserById() {

        //Given
        User johnSmith = new User("John", "Smith", "johnsmith@test.com", 195897465);
        User kateMoods = new User("Kate", "Moods", "katemoods@test.com", 165328974);

        userRepository.save(johnSmith);
        userRepository.save(kateMoods);

        //When
        userRepository.deleteById(johnSmith.getId());
        List<User> users = (List<User>) userRepository.findAll();

        //Then
        assertEquals(1, users.size());
        assertEquals(kateMoods.getId(), users.get(0).getId());

        //CleanUp
        userRepository.deleteAll();
    }

}