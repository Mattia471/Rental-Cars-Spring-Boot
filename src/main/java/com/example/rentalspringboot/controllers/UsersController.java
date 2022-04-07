package com.example.rentalspringboot.controllers;

import com.example.rentalspringboot.dto.UsersResponse;
import com.example.rentalspringboot.entity.Users;
import com.example.rentalspringboot.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = {"http://localhost:4200"},
        methods = {RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET})
public class UsersController {

    @Autowired
    UsersService usersService;

    @Autowired
    PasswordEncoder passwordEncoder;


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
    public ResponseEntity<UsersResponse> listByEmail(@PathVariable("email") String email) {

        UsersResponse user = usersService.getByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @GetMapping(value = "birthdate/{birthdate}", produces = "application/json")
    public ResponseEntity<List<UsersResponse>> listByBirthdate(@PathVariable("birthdate") Date birthdate) {
        List<UsersResponse> user = usersService.getByBirthdate(birthdate);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @PutMapping(value = "edit", produces = "application/json")
    public ResponseEntity<?> editUser(@RequestBody Users user) {
        Users userDb = usersService.getUsersById(user.getId());
        //controllo  password
        if (user.getPassword().equals("")) {
            user.setPassword(userDb.getPassword());
            usersService.saveUser(user);
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword())); //password criptata
            usersService.saveUser(user);
        }
        return ResponseEntity.ok("utente aggiornato ");
    }


    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
        usersService.deleteUser(id);
        return ResponseEntity.ok("utente eliminato");
    }


    @PostMapping(value = "add")
    public ResponseEntity<?> addUser(@RequestBody Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersService.saveUser(user);
        return ResponseEntity.ok("utente aggiunto");
    }
}
