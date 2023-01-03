package com.kodilla.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private Long id;
    private String firstname;
    private String lastname;
    private String mail;
    private int phone;

}
