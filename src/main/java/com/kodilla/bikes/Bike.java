package com.kodilla.bikes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bike {

    private Long id;
    private String type;
    private int size;
}
