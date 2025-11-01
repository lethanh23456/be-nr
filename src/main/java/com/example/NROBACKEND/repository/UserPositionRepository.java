package com.example.NROBACKEND.repository;

import com.example.NROBACKEND.entity.UserPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserPositionRepository extends JpaRepository<UserPosition, Long> {
    Optional<UserPosition> findByUserId(Long userId);
}