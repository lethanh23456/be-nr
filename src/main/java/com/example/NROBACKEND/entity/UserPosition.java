package com.example.NROBACKEND.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_position")
public class UserPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "x")
    private Float x;

    @Column(name = "y")
    private Float y;

    @Column(name = "map_hien_tai")
    private String mapHienTai;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Float getX() { return x; }
    public void setX(Float x) { this.x = x; }

    public Float getY() { return y; }
    public void setY(Float y) { this.y = y; }

    public String getMapHienTai() { return mapHienTai; }
    public void setMapHienTai(String mapHienTai) { this.mapHienTai = mapHienTai; }




}
