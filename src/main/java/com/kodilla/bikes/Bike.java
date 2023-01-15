package com.kodilla.bikes;

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
    private int id;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "SIZE")
    private int size;
}
