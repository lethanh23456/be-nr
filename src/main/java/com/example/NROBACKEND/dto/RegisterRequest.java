package com.example.NROBACKEND.dto;

public class RegisterRequest {
    private String username;
    private String email;
    private String password;
    private String realname;

    // Constructors
    public RegisterRequest() {
    }

    public RegisterRequest(String username, String email, String password, String realname) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.realname = realname;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }
}