package com.example.NROBACKEND.repository;


import com.example.NROBACKEND.entity.Detu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface DetuRepository extends JpaRepository<Detu, Long> {
    Optional<Detu> findByUserId(Long userId);
}
