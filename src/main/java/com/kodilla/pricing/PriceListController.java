package com.kodilla.pricing;

import com.kodilla.exception.PriceListNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pricing/")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PriceListController {

    private final PriceListService priceListService;
    private final PriceListMapper priceListMapper;

    @GetMapping
    public ResponseEntity<List<PriceListDto>> getPriceLists() {
        List<PriceList> prices = priceListService.getaLLPriceLists();
        return ResponseEntity.ok(priceListMapper.mapToListOfPriceLaistDto(prices));
    }

    @GetMapping(value = "{priceListId}")
    public ResponseEntity<PriceListDto> getPriceList(@PathVariable Long priceListId) throws PriceListNotFoundException {
        return ResponseEntity.ok(priceListMapper.mapToPriceListDto(priceListService.getPriceList(priceListId)));
    }

    @DeleteMapping(value = "{priceListId}")
    public ResponseEntity<Void> deletePriceList(@PathVariable Long priceListId) throws PriceListNotFoundException {
        priceListService.deletePriceList(priceListId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createPriceList(@RequestBody PriceListDto priceListDto) {
        PriceList priceList = priceListMapper.mapToPriceList(priceListDto);
        priceListService.savePriceList(priceList);
        return ResponseEntity.ok().build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PriceListDto> updatePriceList(@RequestBody PriceListDto priceListDto) {
        PriceList priceList = priceListMapper.mapToPriceList(priceListDto);
        PriceList savedPriceList = priceListService.savePriceList(priceList);
        return ResponseEntity.ok(priceListMapper.mapToPriceListDto(savedPriceList));
    }
}
