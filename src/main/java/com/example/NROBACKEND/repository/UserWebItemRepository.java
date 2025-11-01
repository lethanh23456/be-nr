package com.example.NROBACKEND.repository;
import com.example.NROBACKEND.entity.UserWebItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserWebItemRepository extends JpaRepository<UserWebItem, Long> {
    List<UserWebItem> findByUserId(Long userId);
    List<UserWebItem> findByUserIdAndIsClaimed(Long userId, Boolean isClaimed);
}