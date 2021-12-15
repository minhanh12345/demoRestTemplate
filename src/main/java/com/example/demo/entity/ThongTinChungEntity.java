package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class ThongTinChungEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String soDKKD;
    @OneToOne(cascade = {CascadeType.ALL})
    private FileGiayToBatBuocEntity fileGiayToBatBuoc;
    private String fileGiayToFATCA;
    @OneToOne(cascade = {CascadeType.ALL})
    private ThongTinToChucEntity thongTinToChuc;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<ThongTinNhanSuEntity> thongTinNhanSu;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<ChuSoHuuHuongLoiEntity> chuSoHuuHuongLoi;
    @OneToOne(cascade = {CascadeType.ALL})
    private ThongTinTKTTEntity thongTinTKTT;
    @OneToOne(cascade = {CascadeType.ALL})
    private ThoaThuanPhapLyEntity thoaThuanPhapLy;
    @OneToOne(cascade = {CascadeType.ALL})
    private DonViKinhDoanhTrenHeThongEntity donViKinhDoanhTrenHeThong;
    @OneToOne(cascade = {CascadeType.ALL})
    private ThongTinDangKySeanetEntity thongTinDangKySeanet;
}
