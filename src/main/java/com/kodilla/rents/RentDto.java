package com.kodilla.rents;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class RentDto {

    private Long id;
    private LocalDate dateOfRent;
    private LocalDate dateOfReturn;
    private Long userId;
    private Long bikeId;
}
