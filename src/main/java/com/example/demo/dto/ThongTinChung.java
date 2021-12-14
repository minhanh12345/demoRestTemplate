package com.example.demo.dto;

import com.example.demo.entity.ChuSoHuuHuongLoiEntity;
import com.example.demo.entity.DonViKinhDoanhTrenHeThongEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
public class ThongTinChung {
    private String soDKKD;
    private FileGiayToBatBuoc fileGiayToBatBuoc;
    private String fileGiayToFATCA;

    private ThongTinToChuc thongTinToChuc;

    private List<ThongTinNhanSu> thongTinNhanSu;

    private List<ChuSoHuuHuongLoiEntity> chuSoHuuHuongLoi;

    private ThongTinTKTT thongTinTKTT;

    private ThoaThuanPhapLy thoaThuanPhapLy;

    private DonViKinhDoanhTrenHeThongEntity donViKinhDoanhTrenHeThong;

    private ThongTinDangKySeanet thongTinDangKySeanet;
}
