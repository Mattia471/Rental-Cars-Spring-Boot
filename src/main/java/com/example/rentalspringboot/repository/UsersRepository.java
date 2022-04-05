package com.example.rentalspringboot.repository;

import com.example.rentalspringboot.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Integer>
{
    Users getById(int id);

    List<Users> getAllBy();

    List<Users> getByRole(String role);

    List<Users> getByName(String name);

    List<Users> getByBirthdate(Date birthdate);

    List<Users> getByEmail(String email);

    List<Users> getBySurname(String surname);

}
