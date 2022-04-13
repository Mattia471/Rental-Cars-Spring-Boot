package com.example.rentalspringboot.service;

import com.example.rentalspringboot.dto.UsersResponse;
import com.example.rentalspringboot.entity.Users;

import java.util.List;

public interface UsersService {
    Users getUsersById(int id);

    UsersResponse getById(int id);

    List<UsersResponse> getAllBy();

    List<UsersResponse> getBySurname(String surname);

    void saveUser(Users user);

    void deleteUser(int id);
}
