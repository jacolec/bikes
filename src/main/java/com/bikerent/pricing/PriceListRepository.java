package com.bikerent.pricing;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceListRepository extends CrudRepository<PriceList, Long> {
}
