package com.kodilla.pricing;

import java.math.BigDecimal;
import java.util.Map;

public class PriceList {

    private static Map<BikeType, BigDecimal> professionalBikePrices = Map.of(
            BikeType.RACING, new BigDecimal(300),
            BikeType.MTB, new BigDecimal(200),
            BikeType.TREKKING, new BigDecimal(100),
            BikeType.CITY, new BigDecimal(100)

    );

    private static Map<BikeType, BigDecimal> casualBikePrices = Map.of(
            BikeType.RACING, new BigDecimal(150),
            BikeType.MTB, new BigDecimal(100),
            BikeType.TREKKING, new BigDecimal(50),
            BikeType.CITY, new BigDecimal(50)
    );
}
