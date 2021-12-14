package com.example.demo.dto;

import com.example.demo.entity.ThongTinChungEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
public class ChuSoHuuHuongLoi {

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

}
