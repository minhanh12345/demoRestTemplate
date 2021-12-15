package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.entity.*;
import com.example.demo.repo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    ObjectMapper mapper;

    public ThongTinChungEntity save(ThongTinChung thongTinChung) {
        ThongTinChungEntity thongTinChungEntity = new ThongTinChungEntity();
        thongTinChungEntity.setSoDKKD(thongTinChung.getSoDKKD());
        thongTinChungEntity.setFileGiayToFATCA(thongTinChung.getFileGiayToFATCA());

        ThoaThuanPhapLyEntity thoaThuanPhapLyEntity = mapper.convertValue(thongTinChung.getThoaThuanPhapLy(), ThoaThuanPhapLyEntity.class);
        thoaThuanPhapLyRepo.save(thoaThuanPhapLyEntity);
        thongTinChungEntity.setThoaThuanPhapLy(thoaThuanPhapLyEntity);



        FileGiayToBatBuocEntity fileGiayToBatBuocEntity = mapper.convertValue(thongTinChung.getFileGiayToBatBuoc(), FileGiayToBatBuocEntity.class);
        thongTinChungEntity.setFileGiayToBatBuoc(fileGiayToBatBuocEntity);
        fileGiayToBatBuocRepo.save(fileGiayToBatBuocEntity);

        ThongTinDangKySeanetEntity thongTinDangKySeanet = mapper.convertValue(thongTinChung.getThongTinDangKySeanet(), ThongTinDangKySeanetEntity.class);
        thongTinChungEntity.setThongTinDangKySeanet(thongTinDangKySeanet);
        thongTinDangKySeanetRepo.save(thongTinDangKySeanet);

        DonViKinhDoanhTrenHeThongEntity donViKinhDoanhTrenHeThongEntity = mapper.convertValue(thongTinChung.getDonViKinhDoanhTrenHeThong(), DonViKinhDoanhTrenHeThongEntity.class);
        thongTinChungEntity.setDonViKinhDoanhTrenHeThong(donViKinhDoanhTrenHeThongEntity);
        donViKinhDoanhTrenHeThongRepo.save(donViKinhDoanhTrenHeThongEntity);

        ThongTinToChucEntity thongTinToChucEntity = mapper.convertValue(thongTinChung.getThongTinToChuc(), ThongTinToChucEntity.class);
        thongTinChungEntity.setThongTinToChuc(thongTinToChucEntity);
        thongTinToChucRepo.save(thongTinToChucEntity);

        List<ThongTinNhanSuEntity> thongTinNhanSuEntityList = new ArrayList<>();
        for (ThongTinNhanSu tt : thongTinChung.getThongTinNhanSu()
        ) {
            ThongTinNhanSuEntity thongTinNhanSu = mapper.convertValue(tt, ThongTinNhanSuEntity.class);

            thongTinNhanSuRepo.save(thongTinNhanSu);
            thongTinNhanSuEntityList.add(thongTinNhanSu);
        }
        thongTinChungEntity.setThongTinNhanSu(thongTinNhanSuEntityList);
        List<ChuSoHuuHuongLoiEntity> chuSoHuuHuongLoiEntityList = new ArrayList<>();
        for (ChuSoHuuHuongLoi tt : thongTinChung.getChuSoHuuHuongLoi()
        ) {
            ChuSoHuuHuongLoiEntity chuSoHuuHuongLoiEntity = mapper.convertValue(tt, ChuSoHuuHuongLoiEntity.class);
            chuSoHuuHuongLoiRepo.save(chuSoHuuHuongLoiEntity);
            chuSoHuuHuongLoiEntityList.add(chuSoHuuHuongLoiEntity);
        }
        thongTinChungEntity.setChuSoHuuHuongLoi(chuSoHuuHuongLoiEntityList);

        ThongTinTKTTEntity thongTinTKTT = mapper.convertValue(thongTinChung.getThongTinTKTT(), ThongTinTKTTEntity.class);
        List<TaiKhoanEntity> taiKhoanEntityList = new ArrayList<>();
        List<SoDienThoaiDangKyEntity> soDienThoaiDangKyEntityList = new ArrayList<>();
        for (TaiKhoan tt : thongTinChung.getThongTinTKTT().getListTaiKhoan()
        ) {
            TaiKhoanEntity taiKhoanEntity = mapper.convertValue(tt, TaiKhoanEntity.class);
            for (String sdt : tt.getListSoDienThoaiDangKy()
            ) {
                SoDienThoaiDangKyEntity soDienThoaiDangKyEntity = new SoDienThoaiDangKyEntity();
                soDienThoaiDangKyEntity.setSdt(sdt);
                soDienThoaiDangKyRepo.save(soDienThoaiDangKyEntity);
                soDienThoaiDangKyEntityList.add(soDienThoaiDangKyEntity);
            }
            taiKhoanEntity.setSoDienThoaiDangKyList(soDienThoaiDangKyEntityList);
            taiKhoanRepo.save(taiKhoanEntity);
            taiKhoanEntityList.add(taiKhoanEntity);
        }
        thongTinTKTT.setListTaiKhoan(taiKhoanEntityList);
        thongTinChungEntity.setThongTinTKTT(thongTinTKTT);
        thongTinTKTTRepo.save(thongTinTKTT);
        thongTinChungRepo.save(thongTinChungEntity);
        return thongTinChungEntity;
    }

    public ThongTinChungEntity getById(Long id) {
        return thongTinChungRepo.getById(id);
    }

}
