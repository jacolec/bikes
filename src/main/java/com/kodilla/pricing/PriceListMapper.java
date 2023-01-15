package com.kodilla.pricing;

import org.springframework.stereotype.Component;

@Component
public class PriceListMapper {

    public PriceListDto mapToPriceListDto(PriceList priceList) {
        return new PriceListDto(priceList.getId(),
                priceList.getRacingPrice(),
                priceList.getMtbPrice(),
                priceList.getTrekkingPrice(),
                priceList.getCityPrice());
    }

    public PriceList mapToPriceList(PriceListDto priceListDto) {
        return new PriceList(priceListDto.getRacingPrice(),
                priceListDto.getMtbPrice(),
                priceListDto.getTrekkingPrice(),
                priceListDto.getCityPrice());
    }
}
