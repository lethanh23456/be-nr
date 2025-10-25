package com.example.NROBACKEND.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Pay")
public class Pay {

    @Id // khoóa chính
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id tự tăng dần
    private Long id;

    // Số tiền thanh toán
    @Column(nullable = false)
    private Long tien;

    // Ngày tạo thanh toán
    @Column(nullable = false)
    private LocalDateTime startDate = LocalDateTime.now();

    // Quan hệ 1-1 với User
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @com.fasterxml.jackson.annotation.JsonBackReference
    private User user;

    // ===== Constructors =====
    public Pay() {}

    public Pay(Long tien, User user) {
        this.tien = tien;
        this.user = user;
        this.startDate = LocalDateTime.now();
    }

    // ===== Getters & Setters =====
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTien() {
        return tien;
    }

    public void setTien(Long tien) {
        this.tien = tien;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
