package com.example.rentalspringboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
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

    //JOIN TRA TABELLA CARS E RESERVATIONS
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    /*@JsonManagedReference //serve al codificatore json*/
    private List<Reservations> reservations;
}
