package com.example.demo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class HoSoKhachHang {
    private String maHS;
    private String ghiChu;
    private String ngayYeuCau;
    private String trangThai;
    private ThongTinChung thongTinChung;
}
