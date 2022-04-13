package com.example.rentalspringboot.controllers;

import com.example.rentalspringboot.dto.UsersResponse;
import com.example.rentalspringboot.entity.Users;
import com.example.rentalspringboot.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
//TODO FILE DI CONFIGURAZIONE PER EVITARE ANNOTAZIONE DUPLICATE
@CrossOrigin(origins = {"http://localhost:4200"},
        methods = {RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET})

public class UsersController {

    @Autowired
    UsersService usersService;


    @GetMapping(value = "id/{id}", produces = "application/json")
    public ResponseEntity<Users> userById(@PathVariable("id") int id) {
        Users user = usersService.getUsersById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(value = "user/{id}", produces = "application/json")
    public ResponseEntity<UsersResponse> userId(@PathVariable("id") int id) {
        UsersResponse user = usersService.getById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<List<UsersResponse>> listAll() {
        List<UsersResponse> user = usersService.getAllBy();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @GetMapping(value = "surname/{surname}", produces = "application/json")
    public ResponseEntity<List<UsersResponse>> listBySurname(@PathVariable("surname") String surname) {
        List<UsersResponse> user = usersService.getBySurname(surname);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @PutMapping(value = "edit", produces = "application/json")
    public ResponseEntity<?> editUser(@RequestBody Users user) {
        usersService.saveUser(user);
        return ResponseEntity.ok("utente aggiornato ");
    }


    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
        usersService.deleteUser(id);
        return ResponseEntity.ok("utente eliminato");
    }


    @PostMapping(value = "add")
    public ResponseEntity<?> addUser(@RequestBody Users user) {
        usersService.saveUser(user);
        return ResponseEntity.ok("utente aggiunto");
    }
}
