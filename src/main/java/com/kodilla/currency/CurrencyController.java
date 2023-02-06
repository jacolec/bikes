package com.kodilla.currency;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency/")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CurrencyController {

    private final CurrencyClient currencyClient;
    private final CurrencyMapper currencyMapper;

    @GetMapping("dollar")
    public ResponseEntity<CurrencyDto> getDollarRate() {
        return ResponseEntity.ok(currencyClient.getDollarRate());
    }

    @GetMapping("euro")
    public ResponseEntity<CurrencyDto> getEuroRate() {
        return ResponseEntity.ok(currencyClient.getEuroRate());
    }
}
