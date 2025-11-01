package com.example.NROBACKEND.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "ma_item")
    private String maItem;

    private String ten;
    private String loai;
    private String mota;
    private String soluong;
    private String hanhlim;

    @Column(name = "set_kich_hoat")
    private String setKichHoat;

    @Column(name = "so_sao_pha_le")
    private String soSaoPhale;

    @Column(name = "so_sao_pha_le_cuong_hoa")
    private String soSaoPhaleCuongHoa;

    @Column(name = "so_cap")
    private String soCap;

    @Column(name = "han_su_dung")
    private Float hanSuDung;

    @Column(name = "suc_manh_yeu_cau")
    private Integer sucManhYeuCau;

    @Column(name = "link_lea")
    private String linkLea;

    private String chisogiap;

    @Column(name = "vutru")
    private String vutru;

    @Column(name = "created_at")
    private LocalDateTime createdAt;


    @OneToOne(mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserWebItem userWebItem;


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

    public String getMaItem() {
        return maItem;
    }

    public void setMaItem(String maItem) {
        this.maItem = maItem;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public String getHanhlim() {
        return hanhlim;
    }

    public void setHanhlim(String hanhlim) {
        this.hanhlim = hanhlim;
    }

    public String getSetKichHoat() {
        return setKichHoat;
    }

    public void setSetKichHoat(String setKichHoat) {
        this.setKichHoat = setKichHoat;
    }

    public String getSoSaoPhale() {
        return soSaoPhale;
    }

    public void setSoSaoPhale(String soSaoPhale) {
        this.soSaoPhale = soSaoPhale;
    }

    public String getSoSaoPhaleCuongHoa() {
        return soSaoPhaleCuongHoa;
    }

    public void setSoSaoPhaleCuongHoa(String soSaoPhaleCuongHoa) {
        this.soSaoPhaleCuongHoa = soSaoPhaleCuongHoa;
    }

    public String getSoCap() {
        return soCap;
    }

    public void setSoCap(String soCap) {
        this.soCap = soCap;
    }

    public Float getHanSuDung() {
        return hanSuDung;
    }

    public void setHanSuDung(Float hanSuDung) {
        this.hanSuDung = hanSuDung;
    }

    public Integer getSucManhYeuCau() {
        return sucManhYeuCau;
    }

    public void setSucManhYeuCau(Integer sucManhYeuCau) {
        this.sucManhYeuCau = sucManhYeuCau;
    }

    public String getLinkLea() {
        return linkLea;
    }

    public void setLinkLea(String linkLea) {
        this.linkLea = linkLea;
    }

    public String getChisogiap() {
        return chisogiap;
    }

    public void setChisogiap(String chisogiap) {
        this.chisogiap = chisogiap;
    }

    public String getVutru() {
        return vutru;
    }

    public void setVutru(String vutru) {
        this.vutru = vutru;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public UserWebItem getUserWebItem() {
        return userWebItem;
    }

    public void setUserWebItem(UserWebItem userWebItem) {
        this.userWebItem = userWebItem;
    }

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}