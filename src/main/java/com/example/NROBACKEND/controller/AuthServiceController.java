package com.example.NROBACKEND.controller;

import com.example.NROBACKEND.dto.LoginRequest;
import com.example.NROBACKEND.dto.RegisterRequest;
import com.example.NROBACKEND.dto.AuthResponse;
import com.example.NROBACKEND.service.AuthServiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthServiceController {

    private final AuthServiceService service;

    public AuthServiceController(AuthServiceService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        AuthResponse response = service.register(request);

        if (response.getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        AuthResponse response = service.login(request);

        if (response.getId() == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        return ResponseEntity.ok(response);
    }
}
