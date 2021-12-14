package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
public class ChuSoHuuHuongLoiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hoVaTen;
    private String loaiCSHHL;
    private Date ngaySinh;
    private String quocTich;
    private String ngheNghiepChucVu;
    private String soDienThoai;
    private String loaiGTND;
    private String soGTND;
    private Date ngayCapGTND;
    private String noiCapGTND;
    private String diaChiThuongTru;
    private String noiOHienTai;
    @ManyToOne
    private ThongTinChungEntity thongTinChungEntity;
}
