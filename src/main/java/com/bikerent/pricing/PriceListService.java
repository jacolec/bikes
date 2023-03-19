package com.bikerent.pricing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceListService {

    @Autowired
    private PriceListRepository priceListRepository;

    public List<PriceList> getaLLPriceLists() {
        return (List<PriceList>) priceListRepository.findAll();
    }

    public PriceList getPriceList(Long priceListId) {
        return priceListRepository.findById(priceListId).get();
    }

    public PriceList savePriceList(final PriceList priceList) {
        return priceListRepository.save(priceList);
    }

    public void deletePriceList(Long priceListId) {
        priceListRepository.deleteById(priceListId);
    }
}
