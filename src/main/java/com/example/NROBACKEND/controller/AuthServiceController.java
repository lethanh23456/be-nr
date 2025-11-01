package com.example.NROBACKEND.controller;


import com.example.NROBACKEND.entity.AuthService;
import com.example.NROBACKEND.service.AuthServiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/auth")

public class AuthServiceController {

    private final AuthServiceService service;

    public AuthServiceController(AuthServiceService service) {
        this.service = service;
    }

    @GetMapping
    public List<AuthService> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthService> getById(@PathVariable Long id) {
        AuthService auth = service.getById(id);
        return auth != null ? ResponseEntity.ok(auth) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public AuthService create(@RequestBody AuthService authService) {
        return service.create(authService);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthService> update(@PathVariable Long id, @RequestBody AuthService authService) {
        AuthService updated = service.update(id, authService);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
