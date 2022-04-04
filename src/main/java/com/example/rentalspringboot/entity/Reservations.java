package com.example.rentalspringboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="reservations")
@Data
public class Reservations implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column
    private Date endDate;

    //join con tabella USERS
    @ManyToOne
    @EqualsAndHashCode.Exclude
    @JoinColumn(name="user_id", nullable = false,referencedColumnName = "id" )
/*
    @JsonBackReference //punto di arrivo
*/
    private Users user;

    //join con tabella CARS
    @ManyToOne
    @EqualsAndHashCode.Exclude
    @JoinColumn(name="car_id", nullable = false ,referencedColumnName = "id" )
/*
    @JsonBackReference //punto di arrivo
*/
    private Cars car;

    @Column
    private String status;
}
