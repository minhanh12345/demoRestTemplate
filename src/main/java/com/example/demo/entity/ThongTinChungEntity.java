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
    @OneToOne
    private FileGiayToBatBuocEntity fileGiayToBatBuoc;
    private String fileGiayToFATCA;
    @OneToOne
    private ThongTinToChucEntity thongTinToChuc;
    @OneToMany
    private List<ThongTinNhanSuEntity> thongTinNhanSu;
    @OneToMany
    private List<ChuSoHuuHuongLoiEntity> chuSoHuuHuongLoi;
    @OneToOne
    private ThongTinTKTTEntity thongTinTKTT;
    @OneToOne
    private ThoaThuanPhapLyEntity thoaThuanPhapLy;
    @OneToOne
    private DonViKinhDoanhTrenHeThongEntity donViKinhDoanhTrenHeThong;
    @OneToOne
    private ThongTinDangKySeanetEntity thongTinDangKySeanet;
}
