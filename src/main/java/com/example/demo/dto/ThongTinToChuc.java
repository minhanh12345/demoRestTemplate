package com.example.demo.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
public class ThongTinToChuc {
    private String tenTV;
    private String tenNN;
    private String tenVietTat;
    private String soDKKD;
    private Date ngayCap;
    private String noiCap;
    private String maSoThue;
    private String linhVucHoatDong;
    private String diaChiTruSoChinh;
    private String diaChiGD;
    private String dienThoaiCoDinh;
    private String fax;
    private String dienThoaiDiDong;
    private String email;
    private String tinhTrangCuTru;
    private String loaiHinhToChuc;
    private String vonDieuLe;
    private String doanhThuNamTruoc;
    private Integer soLuongNhanVien;
    private String tongTaiSan;
    private List<ThongTinDiaChiToChuc> thongTinDiaChiToChuc;

}
