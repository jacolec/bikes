package com.bikerent.user;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDto mapToUserDto(User user) {
        return new UserDto(user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getMail(),
                user.getPhone());
    }

    public User mapToUser(UserDto userDto) {
        return new User(userDto.getFirstname(),
                userDto.getLastname(),
                userDto.getMail(),
                userDto.getPhone());
    }

    public List<UserDto> mapToUserDtoList(List<User> users) {
        return users.stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }
}
