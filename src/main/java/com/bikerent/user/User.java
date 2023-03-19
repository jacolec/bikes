package com.bikerent.user;

import com.bikerent.bikes.Bike;
import com.bikerent.rents.Rent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "USER_ID", unique = true)
    private Long id;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "MAIL")
    private String mail;
    @Column(name = "PHONE")
    private int phone;

    @OneToOne
    @JoinColumn(name = "BIKE_ID")
    private Bike bike;

    @OneToOne
    @JoinColumn(name = "RENT_ID")
    private Rent rent;

    public User(String firstname, String lastname, String mail, int phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.mail = mail;
        this.phone = phone;
    }

    public User(Long id, String firstname, String lastname, String mail, int phone) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.mail = mail;
        this.phone = phone;
    }
}
