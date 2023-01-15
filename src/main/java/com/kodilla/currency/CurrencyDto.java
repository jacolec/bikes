package com.kodilla.currency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CurrencyDto {

    private BigDecimal dollar;
    private BigDecimal euro;
}
