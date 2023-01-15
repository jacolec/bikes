package com.kodilla.currency;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class CurrencyClient {

    private final RestTemplate restTemplate;
    private final CurrencyConfig currencyConfig;

    public String getDollarRate() {

        URI url = UriComponentsBuilder
                .fromHttpUrl(currencyConfig.getCurrencyApiEndPoint() + currencyConfig.getDollar())
                .build()
                .encode()
                .toUri();

        String dollar = restTemplate.getForObject(url, String.class);
        return dollar;
    }

    public String getEuroRate() {

        URI url = UriComponentsBuilder
                .fromHttpUrl(currencyConfig.getCurrencyApiEndPoint() + currencyConfig.getEuro())
                .build()
                .encode()
                .toUri();

        String euro = restTemplate.getForObject(url, String.class);
        return euro;
    }

}
