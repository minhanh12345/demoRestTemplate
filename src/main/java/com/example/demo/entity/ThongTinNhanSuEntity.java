package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class ThongTinNhanSuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String hoVaTen;
    private Date ngaySinh;
    private String soGTTT;
    private Date ngayCap;
    private String noiCap;
    private String soThiThucNhapCanh;
    private Date ngayCapSTTNC;
    private String noiCapSTTNC;
    private String ngheNghiep;
    private String chucVu;
    private String tinhTrangCuTru;
    private String quocTich;
    private String sdt;
    private String email;
    private String diaChiThuongTru;
    private String diaChiHienTai;
    private String diaChiDKCTNuocNgoai;
    private String type;
    @ManyToOne
    private ThongTinChungEntity thongTinChungEntity;
}
