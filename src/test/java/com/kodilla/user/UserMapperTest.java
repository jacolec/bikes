package com.kodilla.user;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {

    private UserMapper userMapper;

    @Test
    void testMapToUserDto() {
        //Given
        User user = new User(1L, "John", "Smith", "test@test.com", 123456789);
        UserDto userDto = new UserDto(1L, "John", "Smith", "test@test.com", 123456789);
        //When
        UserDto testUser = userMapper.mapToUserDto(user);
        //Then
        assertEquals(userDto.getId(), testUser.getId());
        assertEquals(userDto.getFirstname(), testUser.getFirstname());
        assertEquals(userDto.getLastname(), testUser.getLastname());
        assertEquals(userDto.getMail(), testUser.getMail());
        assertEquals(userDto.getPhone(), testUser.getPhone());
    }

    @Test
    void testMapToUser() {
        //Given
        User user = new User(1L, "John", "Smith", "test@test.com", 123456789);
        UserDto userDto = new UserDto(1L, "John", "Smith", "test@test.com", 123456789);
        //When
        User testUser = userMapper.mapToUser(userDto);
        //Then
        assertEquals(user.getId(), testUser.getId());
        assertEquals(user.getFirstname(), testUser.getFirstname());
        assertEquals(user.getLastname(), testUser.getLastname());
        assertEquals(user.getMail(), testUser.getMail());
        assertEquals(user.getPhone(), testUser.getPhone());
    }

    @Test
    void testMapToUserListDto() {
        //Given
        User johnSmith = new User(1L, "John", "Smith", "test@test.com", 123456789);
        User kateMesser = new User(2L, "Kate", "Messer", "kate@test.com", 789456123);
        List<User> users = new ArrayList<>();
        users.add(johnSmith);
        users.add(kateMesser);

        UserDto johnSmithDto = new UserDto(1L, "John", "Smith", "test@test.com", 123456789);
        UserDto kateMesserDto = new UserDto(2L, "Kate", "Messer", "kate@test.com", 789456123);
        List<UserDto> userDtos = new ArrayList<>();
        userDtos.add(johnSmithDto);
        userDtos.add(kateMesserDto);

        //When
        List<UserDto> testList = userMapper.mapToUserDtoList(users);

        //Then
        assertEquals(userDtos.get(0), testList.get(0));
        assertEquals(userDtos.get(1), testList.get(1));
        assertEquals(userDtos.size(), testList.size());


    }

}