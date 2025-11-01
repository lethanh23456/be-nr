package com.example.NROBACKEND.service;

import com.example.NROBACKEND.entity.AuthService;
import com.example.NROBACKEND.repository.AuthServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthServiceService {

    private final AuthServiceRepository repository;

    public AuthServiceService(AuthServiceRepository repository) {
        this.repository = repository;
    }

    public List<AuthService> getAll() {
        return repository.findAll();
    }

    public AuthService getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public AuthService create(AuthService authService) {
        return repository.save(authService);
    }

    public AuthService update(Long id, AuthService authService) {
        if (repository.existsById(id)) {
            authService.setId(id);
            return repository.save(authService);
        }
        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
