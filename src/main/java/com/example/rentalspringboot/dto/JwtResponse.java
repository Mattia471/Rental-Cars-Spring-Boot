package com.example.rentalspringboot.dto;

public class JwtResponse {
    String access_token;
    int id;
    String email;
    String role;

    public JwtResponse(String access_token, int id, String email, String role) {
        this.access_token = access_token;
        this.id = id;
        this.email = email;
        this.role = role;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
