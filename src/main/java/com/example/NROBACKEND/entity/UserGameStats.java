package com.example.NROBACKEND.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_game_stats")
public class UserGameStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private Integer vang;
    private Integer ngoc;

    @Column(name = "suc_manh")
    private Integer sucManh;

    @Column(name = "vang_nao_tu_web")
    private Integer vangNaoTuWeb;

    @Column(name = "ngoc_nao_tu_web")
    private Integer ngocNaoTuWeb;

    @Column(name = "da_vao_tk_lan_dau")
    private Boolean daVaoTkLanDau;

    @Column(name = "co_de_tu")
    private Boolean coDeTu;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getVang() {
        return vang;
    }

    public void setVang(Integer vang) {
        this.vang = vang;
    }

    public Integer getNgoc() {
        return ngoc;
    }

    public void setNgoc(Integer ngoc) {
        this.ngoc = ngoc;
    }

    public Integer getSucManh() {
        return sucManh;
    }

    public void setSucManh(Integer sucManh) {
        this.sucManh = sucManh;
    }

    public Integer getVangNaoTuWeb() {
        return vangNaoTuWeb;
    }

    public void setVangNaoTuWeb(Integer vangNaoTuWeb) {
        this.vangNaoTuWeb = vangNaoTuWeb;
    }

    public Integer getNgocNaoTuWeb() {
        return ngocNaoTuWeb;
    }

    public void setNgocNaoTuWeb(Integer ngocNaoTuWeb) {
        this.ngocNaoTuWeb = ngocNaoTuWeb;
    }

    public Boolean getDaVaoTkLanDau() {
        return daVaoTkLanDau;
    }

    public void setDaVaoTkLanDau(Boolean daVaoTkLanDau) {
        this.daVaoTkLanDau = daVaoTkLanDau;
    }

    public Boolean getCoDeTu() {
        return coDeTu;
    }

    public void setCoDeTu(Boolean coDeTu) {
        this.coDeTu = coDeTu;
    }
}