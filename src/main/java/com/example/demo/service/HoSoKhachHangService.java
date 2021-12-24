package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.entity.*;
import com.example.demo.repo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service
public class HoSoKhachHangService {
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
    @Autowired
    ObjectMapper mapper;
    @Autowired
    HoSoKhachHangRepo hoSoKhachHangRepo;


    public HoSoKhachHang getByMaHS(String  maHS)  {
        HoSoKhachHangEntity hoSoKhachHangEntity = hoSoKhachHangRepo.findAllByMaHs(maHS);
        if(hoSoKhachHangEntity == null){
           return  null;
        }
       if(hoSoKhachHangEntity.getMaHs().equals(maHS)){
           HoSoKhachHang hoSoKhachHang = new HoSoKhachHang();
           hoSoKhachHang.setMaHS(hoSoKhachHangEntity.getMaHs());
           hoSoKhachHang.setGhiChu(hoSoKhachHangEntity.getGhiChu());
           hoSoKhachHang.setNgayYeuCau(hoSoKhachHangEntity.getNgayYeuCau());
           hoSoKhachHang.setTrangThai(hoSoKhachHangEntity.getTrangThai());

           ThongTinChung thongTinChungEntity = mapper.convertValue(hoSoKhachHangEntity.getThongTinChungEntity(), ThongTinChung.class );
           hoSoKhachHang.setThongTinChung(thongTinChungEntity);
           return hoSoKhachHang;

       }
        return null;
    }

    public  void  deleteCaseById(Long id){
        hoSoKhachHangRepo.delete(hoSoKhachHangRepo.findAllById(id));
    }

    public  void  deleteCaseByMaHS(String maHS){
        hoSoKhachHangRepo.delete(hoSoKhachHangRepo.findAllByMaHs(maHS));
    }
}
