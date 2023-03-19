package com.bikerent.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDto {

    private Long id;
    private String firstname;
    private String lastname;
    private String mail;
    private int phone;
}
