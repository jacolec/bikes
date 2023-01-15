package com.kodilla.currency;

import org.springframework.stereotype.Component;

@Component
public class CurrencyMapper {

    public CurrencyDto mapToCurrencyDto(Currency currency) {
        return new CurrencyDto(currency.getDollar(), currency.getEuro());
    }

    public Currency mapToCurrency(CurrencyDto currencyDto) {
        return new Currency(currencyDto.getDollar(), currencyDto.getEuro());
    }
}
