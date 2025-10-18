package com.example.NROBACKEND.DTO;
import java.util.*;
import com.example.NROBACKEND.entity.DeTu;
import com.example.NROBACKEND.entity.Item;
import com.example.NROBACKEND.entity.User;

public class ResponseUser {
    public Long id;
    public String username;
    public boolean biBan;
    public String role;
    public Long vang;
    public Long ngoc;
    public Long vangNapTuWeb;
    public Long ngocNapTuWeb;
    public Long sucManh;
    public Float x;
    public Float y;
    public String mapHienTai;
    public boolean daVaoTaiKhoanLanDau;
    public boolean coDeTu;
    public DeTu deTu;
    public List<Item> items;
    public List<Integer> danhSachVatPhamWeb;
    public ResponseUser(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.biBan = user.isBiBan();
        this.role = user.getRole();
        this.vang = user.getVang();
        this.ngoc = user.getNgoc();
        this.vangNapTuWeb = user.getVangNapTuWeb();
        this.ngocNapTuWeb = user.getNgocNapTuWeb();
        this.sucManh = user.getSucManh();
        this.x = user.getX();
        this.y = user.getY();
        this.mapHienTai = user.getMapHienTai();
        this.daVaoTaiKhoanLanDau = user.isDaVaoTaiKhoanLanDau();
        this.coDeTu = user.isCoDeTu();
        this.deTu = user.getDeTu();
        this.items = user.getItems();
        this.danhSachVatPhamWeb = user.getDanhSachVatPhamWeb();
    }
}