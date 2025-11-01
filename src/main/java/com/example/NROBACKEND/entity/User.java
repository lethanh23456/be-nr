package com.example.NROBACKEND.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auth_id", referencedColumnName = "id")
    private AuthService authService;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Detu detu;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserGameStats userGameStats;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserPosition userPosition;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<UserWebItem> userWebItems = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AuthService getAuthService() {
        return authService;
    }

    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    public Detu getDetu() {
        return detu;
    }

    public void setDetu(Detu detu) {
        this.detu = detu;
    }

    public UserGameStats getUserGameStats() {
        return userGameStats;
    }

    public void setUserGameStats(UserGameStats userGameStats) {
        this.userGameStats = userGameStats;
    }

    public UserPosition getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(UserPosition userPosition) {
        this.userPosition = userPosition;
    }

    public List<UserWebItem> getUserWebItems() {
        return userWebItems;
    }

    public void setUserWebItems(List<UserWebItem> userWebItems) {
        this.userWebItems = userWebItems;
    }

}