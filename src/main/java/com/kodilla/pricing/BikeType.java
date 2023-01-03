package com.kodilla.pricing;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public enum BikeType {

    RACING(new BigDecimal(300), new BigDecimal(150)),
    MTB(new BigDecimal(200), new BigDecimal(100)),
    TREKKING(new BigDecimal(100), new BigDecimal(50)),
    CITY(new BigDecimal(100), new BigDecimal(50));

    private BigDecimal professionalBike;
    private BigDecimal casualBike;


}
