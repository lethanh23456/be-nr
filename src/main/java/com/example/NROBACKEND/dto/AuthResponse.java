package com.example.NROBACKEND.dto;

public class AuthResponse {
    private Long id;
    private String username;
    private String email;
    private String realname;
    private String role;
    private String message;

    // Constructors
    public AuthResponse() {
    }

    public AuthResponse(Long id, String username, String email, String realname, String role, String message) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.realname = realname;
        this.role = role;
        this.message = message;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}