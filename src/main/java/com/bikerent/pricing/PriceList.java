package com.bikerent.pricing;

import com.bikerent.bikes.Bike;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "PRICE_LIST")
public class PriceList {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "PRICE_LIST_ID", unique = true)
    private Long id;

    @Column(name = "RACING_PRICE")
    private BigDecimal racingPrice;
    @Column(name = "MTB_PRICE")
    private BigDecimal mtbPrice;
    @Column(name = "TREKKING_PRICE")
    private BigDecimal trekkingPrice;
    @Column(name = "CITY_PRICE")
    private BigDecimal cityPrice;

    public PriceList(BigDecimal racingPrice, BigDecimal mtbPrice, BigDecimal trekkingPrice, BigDecimal cityPrice) {
        this.racingPrice = racingPrice;
        this.mtbPrice = mtbPrice;
        this.trekkingPrice = trekkingPrice;
        this.cityPrice = cityPrice;
    }

    @OneToMany(
            targetEntity = Bike.class,
            mappedBy = "priceList",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private List<Bike> bikes;
}
