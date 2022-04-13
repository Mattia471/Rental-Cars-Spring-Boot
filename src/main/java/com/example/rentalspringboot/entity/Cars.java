package com.example.rentalspringboot.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "cars")
@Data
public class Cars implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String type;

    @Column
    private String manufacturer;

    @Column
    private String model;

    @Column
    private String year;

    @Column
    private String licensePlate;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Reservations> reservations;
}
