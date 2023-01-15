package com.kodilla.user;

import org.springframework.stereotype.Component;

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
}
