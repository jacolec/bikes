package com.bikerent.pricing;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PriceListTest {

    private PriceListRepository priceListRepository;

    @Test
    void testFindPriceListById() {

        //Given
        PriceList priceList1 = new PriceList(
                new BigDecimal(100),
                new BigDecimal(100),
                new BigDecimal(50),
                new BigDecimal(45)
        );

        PriceList priceList2 = new PriceList(
                new BigDecimal(120),
                new BigDecimal(120),
                new BigDecimal(60),
                new BigDecimal(50)
        );

        priceListRepository.save(priceList1);
        priceListRepository.save(priceList2);

        //When
        Long priceList1Id = priceList1.getId();
        Long priceList2Id = priceList2.getId();

        Optional<PriceList> testPriceList1 = priceListRepository.findById(priceList1Id);
        Optional<PriceList> testPriceList2 = priceListRepository.findById(priceList2Id);

        //Then
        assertEquals(priceList1Id, testPriceList1.get().getId());
        assertEquals(priceList2Id, testPriceList2.get().getId());

        //CleanUp
        priceListRepository.deleteAll();
    }

    @Test
    void testDeleteRentById() {

        //Given
        PriceList priceList1 = new PriceList(
                new BigDecimal(100),
                new BigDecimal(100),
                new BigDecimal(50),
                new BigDecimal(45)
        );

        PriceList priceList2 = new PriceList(
                new BigDecimal(120),
                new BigDecimal(120),
                new BigDecimal(60),
                new BigDecimal(50)
        );

        priceListRepository.save(priceList1);
        priceListRepository.save(priceList2);

        //When
        priceListRepository.deleteById(priceList2.getId());
        List<PriceList> priceLists = (List<PriceList>) priceListRepository.findAll();

        //Then
        assertEquals(priceList1.getId(), priceLists.get(0).getId());
        assertEquals(1, priceLists.size());

        //CleanUp
        priceListRepository.deleteAll();
    }

}