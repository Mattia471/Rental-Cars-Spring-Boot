package com.example.rentalspringboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="users")
@Data
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String name;

    @Column//inserire solo (name= "") se il nome è diverso dalla variabile
    private String surname;

    @Column
    private String email;

    @Column
    private String password;


    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column
    private Date birthdate;

    //JOIN TRA TABELLA USERS E RESERVATIONS
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    /*@JsonManagedReference //serve al codificatore json punto di partenza*/
    private List<Reservations> reservations;

    @Column
    private String role;
}
