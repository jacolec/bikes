package com.bikerent.rents;

import com.bikerent.bikes.Bike;
import com.bikerent.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "RENTS")
public class Rent {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "RENT_ID", unique = true)
    private Long id;
    @Column(name = "RENT_DATE")
    private LocalDate dateOfRent;
    @Column(name = "RETURN_DATE")
    private LocalDate dateOfReturn;

    public Rent(LocalDate dateOfRent, LocalDate dateOfReturn) {
        this.dateOfRent = dateOfRent;
        this.dateOfReturn = dateOfReturn;
    }

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToOne
    @JoinColumn(name = "BIKE_ID")
    private Bike bike;

    public Rent(LocalDate dateOfRent, LocalDate dateOfReturn, User user, Bike bike) {
        this.dateOfRent = dateOfRent;
        this.dateOfReturn = dateOfReturn;
        this.user = user;
        this.bike = bike;
    }


}
