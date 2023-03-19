package com.bikerent.bikes;

import com.bikerent.pricing.PriceList;
import com.bikerent.rents.Rent;
import com.bikerent.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "BIKES")
public class Bike {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "BIKE_ID", unique = true)
    private Long id;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "SIZE")
    private int size;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToOne
    @JoinColumn(name = "RENT_ID")
    private Rent rent;

    public Bike(String type, int size) {
        this.type = type;
        this.size = size;
    }

    public Bike(Long id, String type, int size) {
        this.id = id;
        this.type = type;
        this.size = size;
    }

    @ManyToOne
    @JoinColumn(name = "PRICE_LIST_ID")
    private PriceList priceList;
}
