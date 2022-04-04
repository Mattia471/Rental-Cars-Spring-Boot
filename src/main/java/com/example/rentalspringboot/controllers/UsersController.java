package com.example.rentalspringboot.controllers;

import com.example.rentalspringboot.dto.UsersResponse;
import com.example.rentalspringboot.entity.Users;
import com.example.rentalspringboot.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = {"*"})
public class UsersController {

    @Autowired
    private UsersService usersService;


    //TODO NON FUNZIONANTE
    @GetMapping(value = "id/{id}", produces = "application/json")
    public ResponseEntity<UsersResponse> userById(@PathVariable("id") int id) {
        UsersResponse user = usersService.getById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<List<UsersResponse>> listAll() {
        List<UsersResponse> user = usersService.getAllBy();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(value = "name/{name}", produces = "application/json")
    public ResponseEntity<List<UsersResponse>> listByName(@PathVariable("name") String name) {
        List<UsersResponse> user = usersService.getByName(name);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    //estrapola la lista di utenti con ruolo inserito in input
    @GetMapping(value = "role/{role}", produces = "application/json")
    public ResponseEntity<List<UsersResponse>> listByRole(@PathVariable("role") String role) {

        List<UsersResponse> user = usersService.getByRole(role);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @GetMapping(value = "surname/{surname}", produces = "application/json")
    public ResponseEntity<List<UsersResponse>> listBySurname(@PathVariable("surname") String surname) {
        List<UsersResponse> user = usersService.getBySurname(surname);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    //estrapola la lista di utenti con ruolo inserito in input
    @GetMapping(value = "email/{email}", produces = "application/json")
    public ResponseEntity<List<UsersResponse>> listByEmail(@PathVariable("email") String email) {

        List<UsersResponse> user = usersService.getByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @GetMapping(value = "birthdate/{birthdate}", produces = "application/json")
    public ResponseEntity<List<UsersResponse>> listByBirthdate(@PathVariable("birthdate") Date birthdate) {
        List<UsersResponse> user = usersService.getByBirthdate(birthdate);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @PutMapping(value = "edit", produces = "application/json")
    public ResponseEntity<?> editUser(@RequestBody Users user) {
        usersService.saveUser(user);
        return ResponseEntity.ok("utente aggiornato ");
    }


    @DeleteMapping(value = "delete/{id})")
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
