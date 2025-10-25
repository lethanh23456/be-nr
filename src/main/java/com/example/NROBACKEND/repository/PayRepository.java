package com.example.NROBACKEND.repository;

import com.example.NROBACKEND.entity.Pay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PayRepository extends JpaRepository<Pay, Long> {


}

