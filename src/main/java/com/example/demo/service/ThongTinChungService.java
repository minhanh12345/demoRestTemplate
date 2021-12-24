package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.entity.*;
import com.example.demo.repo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.javaws.exceptions.ErrorCodeResponseException;
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

        for (TaiKhoan tt : thongTinChung.getThongTinTKTT().getListTaiKhoan()
        ) {
            TaiKhoanEntity taiKhoanEntity = mapper.convertValue(tt, TaiKhoanEntity.class);
            List<SoDienThoaiDangKyEntity> soDienThoaiDangKyEntityList = new ArrayList<>();
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

    public ThongTinChung getById(Long id) {
        ThongTinChungEntity thongTinChungEntity = thongTinChungRepo.findAllById(id);

        ThongTinChung thongTinChung = new ThongTinChung();
        thongTinChung.setSoDKKD(thongTinChungEntity.getSoDKKD());
        thongTinChung.setFileGiayToFATCA(thongTinChungEntity.getFileGiayToFATCA());

        FileGiayToBatBuoc fileGiayToBatBuoc = mapper.convertValue(thongTinChungEntity.getFileGiayToBatBuoc(), FileGiayToBatBuoc.class);
        thongTinChung.setFileGiayToBatBuoc(fileGiayToBatBuoc);

        ThongTinToChuc thongTinToChuc = mapper.convertValue(thongTinChungEntity.getThongTinToChuc(), ThongTinToChuc.class);
        thongTinChung.setThongTinToChuc(thongTinToChuc);

        ThoaThuanPhapLy thoaThuanPhapLy = mapper.convertValue(thongTinChungEntity.getThoaThuanPhapLy(), ThoaThuanPhapLy.class);
        thongTinChung.setThoaThuanPhapLy(thoaThuanPhapLy);

        DonViKinhDoanhTrenHeThong donViKinhDoanhTrenHeThong = mapper.convertValue(thongTinChungEntity.getDonViKinhDoanhTrenHeThong(), DonViKinhDoanhTrenHeThong.class);
        thongTinChung.setDonViKinhDoanhTrenHeThong(donViKinhDoanhTrenHeThong);

        ThongTinDangKySeanet thongTinDangKySeanet = mapper.convertValue(thongTinChungEntity.getThongTinDangKySeanet(), ThongTinDangKySeanet.class);
        thongTinChung.setThongTinDangKySeanet(thongTinDangKySeanet);

        List<ThongTinNhanSu> thongTinNhanSuList = new ArrayList<>();
        for (ThongTinNhanSuEntity tt : thongTinChungEntity.getThongTinNhanSu()
        ) {
            ThongTinNhanSu thongTinNhanSu = mapper.convertValue(tt, ThongTinNhanSu.class);
            thongTinNhanSuList.add(thongTinNhanSu);
        }
        thongTinChung.setThongTinNhanSu(thongTinNhanSuList);

        List<ChuSoHuuHuongLoi> chuSoHuuHuongLoiList = new ArrayList<>();
        for (ChuSoHuuHuongLoiEntity tt : thongTinChungEntity.getChuSoHuuHuongLoi()
        ) {
            ChuSoHuuHuongLoi chuSoHuuHuongLoi = mapper.convertValue(tt, ChuSoHuuHuongLoi.class);
            chuSoHuuHuongLoiList.add(chuSoHuuHuongLoi);
        }
        thongTinChung.setChuSoHuuHuongLoi(chuSoHuuHuongLoiList);

        ThongTinTKTT thongTinTKTT = mapper.convertValue(thongTinChungEntity.getThongTinTKTT(), ThongTinTKTT.class);

        List<TaiKhoan> taiKhoanList = new ArrayList<>();

        for (TaiKhoanEntity tt : thongTinChungEntity.getThongTinTKTT().getListTaiKhoan()
        ) {
            TaiKhoan taiKhoan = mapper.convertValue(tt, TaiKhoan.class);
            List<String> soDienThoaiDangKyList = new ArrayList<>();
            for (SoDienThoaiDangKyEntity sdt : tt.getSoDienThoaiDangKyList()
            ) {
                soDienThoaiDangKyList.add(sdt.getSdt());
            }
            taiKhoan.setListSoDienThoaiDangKy(soDienThoaiDangKyList);
            taiKhoanList.add(taiKhoan);
        }
        thongTinTKTT.setListTaiKhoan(taiKhoanList);
        thongTinChung.setThongTinTKTT(thongTinTKTT);

        return thongTinChung;
    }

    public ThongTinChungEntity update(ThongTinChung thongTinChung, Long id) {
        ThongTinChungEntity thongTinChungEntity = thongTinChungRepo.findAllById(id);
        if (thongTinChung == null) {
        }
        thongTinChungEntity.setSoDKKD(thongTinChung.getSoDKKD());
        thongTinChungEntity.setFileGiayToFATCA(thongTinChung.getFileGiayToFATCA());


        ThoaThuanPhapLyEntity thoaThuanPhapLyEntity = mapper.convertValue(thongTinChung.getThoaThuanPhapLy(), ThoaThuanPhapLyEntity.class);
        thoaThuanPhapLyEntity.setId(thongTinChungEntity.getThoaThuanPhapLy().getId());
        thoaThuanPhapLyRepo.save(thoaThuanPhapLyEntity);


        FileGiayToBatBuocEntity fileGiayToBatBuocEntity = mapper.convertValue(thongTinChung.getFileGiayToBatBuoc(), FileGiayToBatBuocEntity.class);
        fileGiayToBatBuocEntity.setId(thongTinChungEntity.getFileGiayToBatBuoc().getId());
        fileGiayToBatBuocRepo.save(fileGiayToBatBuocEntity);

        ThongTinDangKySeanetEntity thongTinDangKySeanet = mapper.convertValue(thongTinChung.getThongTinDangKySeanet(), ThongTinDangKySeanetEntity.class);
        thongTinDangKySeanet.setId(thongTinChungEntity.getThongTinDangKySeanet().getId());
        thongTinDangKySeanetRepo.save(thongTinDangKySeanet);

        DonViKinhDoanhTrenHeThongEntity donViKinhDoanhTrenHeThongEntity = mapper.convertValue(thongTinChung.getDonViKinhDoanhTrenHeThong(), DonViKinhDoanhTrenHeThongEntity.class);
        donViKinhDoanhTrenHeThongEntity.setId(thongTinChungEntity.getDonViKinhDoanhTrenHeThong().getId());
        donViKinhDoanhTrenHeThongRepo.save(donViKinhDoanhTrenHeThongEntity);

        ThongTinToChucEntity thongTinToChucEntity = mapper.convertValue(thongTinChung.getThongTinToChuc(), ThongTinToChucEntity.class);
        thongTinToChucEntity.setId(thongTinChungEntity.getThongTinToChuc().getId());
        thongTinToChucRepo.save(thongTinToChucEntity);

        List<ThongTinNhanSuEntity> thongTinNhanSuEntityList = new ArrayList<>();
        for (int i = 0; i < thongTinChung.getThongTinNhanSu().size(); i++
        ) {
            ThongTinNhanSuEntity thongTinNhanSu = mapper.convertValue(thongTinChung.getThongTinNhanSu().get(i), ThongTinNhanSuEntity.class);
            thongTinNhanSu.setId(thongTinChungEntity.getThongTinNhanSu().get(i).getId());
            thongTinNhanSuRepo.save(thongTinNhanSu);
            thongTinNhanSuEntityList.add(thongTinNhanSu);
        }
        thongTinChungEntity.setThongTinNhanSu(thongTinNhanSuEntityList);

        List<ChuSoHuuHuongLoiEntity> chuSoHuuHuongLoiEntityList = new ArrayList<>();
        for (int i = 0; i<thongTinChung.getChuSoHuuHuongLoi().size(); i++
        ) {
            ChuSoHuuHuongLoiEntity chuSoHuuHuongLoiEntity = mapper.convertValue(thongTinChung.getChuSoHuuHuongLoi().get(i), ChuSoHuuHuongLoiEntity.class);
            chuSoHuuHuongLoiEntity.setId(thongTinChungEntity.getChuSoHuuHuongLoi().get(i).getId());
            chuSoHuuHuongLoiRepo.save(chuSoHuuHuongLoiEntity);
//            chuSoHuuHuongLoiEntityList.add(chuSoHuuHuongLoiEntity);
        }
        thongTinChungEntity.setChuSoHuuHuongLoi(chuSoHuuHuongLoiEntityList);

        ThongTinTKTTEntity thongTinTKTT = mapper.convertValue(thongTinChung.getThongTinTKTT(), ThongTinTKTTEntity.class);

        List<TaiKhoanEntity> taiKhoanEntityList = new ArrayList<>();

        for (int i=0; i< thongTinChung.getThongTinTKTT().getListTaiKhoan().size(); i++
        ) {
            TaiKhoanEntity taiKhoanEntity = mapper.convertValue(thongTinChung.getThongTinTKTT().getListTaiKhoan().get(i), TaiKhoanEntity.class);
            List<SoDienThoaiDangKyEntity> soDienThoaiDangKyEntityList = new ArrayList<>();
            for (int j = 0;  j < thongTinChung.getThongTinTKTT().getListTaiKhoan().get(i).getListSoDienThoaiDangKy().size(); j++
            ) {
                SoDienThoaiDangKyEntity soDienThoaiDangKyEntity = new SoDienThoaiDangKyEntity();
                soDienThoaiDangKyEntity.setId(taiKhoanEntity.getId());
                soDienThoaiDangKyRepo.save(soDienThoaiDangKyEntity);
//                soDienThoaiDangKyEntityList.add(soDienThoaiDangKyEntity);
            }
            taiKhoanEntity.setSoDienThoaiDangKyList(soDienThoaiDangKyEntityList);
            taiKhoanRepo.save(taiKhoanEntity);
//            taiKhoanEntityList.add(taiKhoanEntity);
        }
        thongTinTKTT.setListTaiKhoan(taiKhoanEntityList);
        thongTinChungEntity.setThongTinTKTT(thongTinTKTT);
        thongTinTKTTRepo.save(thongTinTKTT);
        thongTinChungRepo.save(thongTinChungEntity);
        return thongTinChungEntity;
    }
}
