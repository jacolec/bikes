package com.kodilla.bikes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BikeDto {

    private Long Id;
    private String type;
    private int size;
}
