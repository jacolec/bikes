package com.bikerent.pricing;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class PriceListDto {

    private Long id;
    private BigDecimal racingPrice;
    private BigDecimal mtbPrice;
    private BigDecimal trekkingPrice;
    private BigDecimal cityPrice;
}
