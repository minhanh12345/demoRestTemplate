package com.example.demo.service;

import com.example.demo.dto.ThongTinChung;
import com.example.demo.entity.ThongTinChungEntity;
import com.example.demo.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThongTinChungService {
    @Autowired
    ChuSoHuuHuongLoiRepo chuSoHuuHuongLoiRepo;
    @Autowired
    DonViKinhDoanhTrenHeThongRepo donViKinhDoanhTrenHeThongRepo;
    @Autowired
    FileGiayToBatBuocRepo fileGiayToBatBuocRepo;
    @Autowired
    SoDienThoaiDangKyRepo soDienThoaiDangKyRepo;
    @Autowired
    TaiKhoanRepo taiKhoanRepo;
    @Autowired
    ThoaThuanPhapLyRepo thoaThuanPhapLyRepo;
    @Autowired
    ThongTinChungRepo thongTinChungRepo;
    @Autowired
    ThongTinDangKySeanetRepo thongTinDangKySeanetRepo;
    @Autowired
    ThongTinDiaChiToChucRepo thongTinDiaChiToChucRepo;
    @Autowired
    ThongTinNhanSuRepo thongTinNhanSuRepo;
    @Autowired
    ThongTinTKTTRepo thongTinTKTTRepo;
    @Autowired
    ThongTinToChucRepo thongTinToChucRepo;

    public ThongTinChungEntity save(ThongTinChung thongTinChung){
        return  null;
    }


}
