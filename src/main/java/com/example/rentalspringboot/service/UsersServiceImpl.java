package com.example.rentalspringboot.service;

import com.example.rentalspringboot.dto.UsersResponse;
import com.example.rentalspringboot.entity.Users;
import com.example.rentalspringboot.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional//tutte le query sotto transazione
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public UsersResponse getById(int id) {
        Users users = usersRepository.getById(id);
        UsersResponse response = new UsersResponse();
        response.setId(users.getId());
        response.setSurname(users.getSurname());
        response.setName(users.getName());
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
            response.setBirthdate(res.getBirthdate());
            response.setRole(res.getRole());
            usersResponses.add(response);
        }
        return usersResponses;
    }

    @Override
    public List<UsersResponse> getByName(String nome) {
        List<UsersResponse> usersResponses = new ArrayList<>();
        List<Users> users = usersRepository.getByName(nome);
        for (Users res : users) {
            UsersResponse response = new UsersResponse();
            response.setId(res.getId());
            response.setSurname(res.getSurname());
            response.setName(res.getName());
            response.setEmail(res.getEmail());
            response.setBirthdate(res.getBirthdate());
            response.setRole(res.getRole());
            usersResponses.add(response);
        }
        return usersResponses;
    }

    @Override
    public List<UsersResponse> getByRole(String admin) {
        List<UsersResponse> usersResponses = new ArrayList<>();
        List<Users> users = usersRepository.getByRole(admin);
        for (Users res : users) {
            UsersResponse response = new UsersResponse();
            response.setId(res.getId());
            response.setSurname(res.getSurname());
            response.setName(res.getName());
            response.setEmail(res.getEmail());
            response.setBirthdate(res.getBirthdate());
            response.setRole(res.getRole());
            usersResponses.add(response);
        }
        return usersResponses;
    }

    @Override
    public List<UsersResponse> getByBirthdate(Date birthdate) {
        List<UsersResponse> usersResponses = new ArrayList<>();
        List<Users> users = usersRepository.getByBirthdate(birthdate);
        for (Users res : users) {
            UsersResponse response = new UsersResponse();
            response.setId(res.getId());
            response.setSurname(res.getSurname());
            response.setName(res.getName());
            response.setEmail(res.getEmail());
            response.setBirthdate(res.getBirthdate());
            response.setRole(res.getRole());
            usersResponses.add(response);
        }
        return usersResponses;
    }

    @Override
    public List<UsersResponse> getByEmail(String email) {
        List<UsersResponse> usersResponses = new ArrayList<>();
        List<Users> users = usersRepository.getByEmail(email);
        for (Users res : users) {
            UsersResponse response = new UsersResponse();
            response.setId(res.getId());
            response.setSurname(res.getSurname());
            response.setName(res.getName());
            response.setEmail(res.getEmail());
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
            response.setBirthdate(res.getBirthdate());
            response.setRole(res.getRole());
            usersResponses.add(response);
        }
        return usersResponses;
    }

    @Override
    public void saveUser(Users user) {
        usersRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        usersRepository.deleteById(id);
    }


}
