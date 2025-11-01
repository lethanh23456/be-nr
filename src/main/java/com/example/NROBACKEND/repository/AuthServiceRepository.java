package com.example.NROBACKEND.repository;

import com.example.NROBACKEND.entity.AuthService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AuthServiceRepository extends JpaRepository<AuthService, Long> {
    Optional<AuthService> findByUsername(String username);
    Optional<AuthService> findByEmail(String email);
}