package com.example.rentalspringboot.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UsersResponse {
    private int id;
    private String name;
    private String surname;
    private String email;
    private Date birthdate;
    private String role;
}
