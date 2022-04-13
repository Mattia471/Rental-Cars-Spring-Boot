package com.example.rentalspringboot.service;

import com.example.rentalspringboot.dto.UsersResponse;
import com.example.rentalspringboot.entity.Users;
import com.example.rentalspringboot.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Users getUsersById(int id) {
        return usersRepository.getUsersById(id);
    }

    @Override
    public UsersResponse getById(int id) {
        Users users = usersRepository.getById(id);
        UsersResponse response = new UsersResponse();
        response.setId(users.getId());
        response.setSurname(users.getSurname());
        response.setName(users.getName());
        response.setPassword(users.getPassword());
        response.setEmail(users.getEmail());
        response.setBirthdate(users.getBirthdate());
        response.setRole(users.getRole());
        return response;
    }

    @Override
    public List<UsersResponse> getAllBy() {
        List<UsersResponse> usersResponses = new ArrayList<>();
        List<Users> users = usersRepository.getAllBy();
        for (Users res : users) {
            UsersResponse response = new UsersResponse();
            response.setId(res.getId());
            response.setSurname(res.getSurname());
            response.setName(res.getName());
            response.setEmail(res.getEmail());
            response.setPassword(res.getPassword());
            response.setBirthdate(res.getBirthdate());
            response.setRole(res.getRole());
            usersResponses.add(response);
        }
        return usersResponses;
    }


    @Override
    public List<UsersResponse> getBySurname(String surname) {
        List<UsersResponse> usersResponses = new ArrayList<>();
        List<Users> users = usersRepository.getBySurname(surname);
        for (Users res : users) {
            UsersResponse response = new UsersResponse();
            response.setId(res.getId());
            response.setSurname(res.getSurname());
            response.setName(res.getName());
            response.setEmail(res.getEmail());
            response.setPassword(res.getPassword());
            response.setBirthdate(res.getBirthdate());
            response.setRole(res.getRole());
            usersResponses.add(response);
        }
        return usersResponses;
    }

    @Override
    public void saveUser(Users user) {
        Users userDb = usersRepository.getUsersById(user.getId());
        //controllo  password
        if (user.getPassword().equals("")) {
            user.setPassword(userDb.getPassword());
            usersRepository.save(user);
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword())); //password criptata
            usersRepository.save(user);
        }
    }

    @Override
    public void deleteUser(int id) {
        usersRepository.deleteById(id);
    }


}
