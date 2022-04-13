package com.example.rentalspringboot.repository;

import com.example.rentalspringboot.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users getUsersById(int id);

    Users getById(int id);

    List<Users> getAllBy();

    Users getByEmail(String email);

    List<Users> getBySurname(String surname);

    Optional<Users> findByEmail(String email);

}
