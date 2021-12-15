package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class FileGiayToBatBuocEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String giayChungNhanDKKD;
    private  String giayUyQuyenNguoiDaiDienPL;
    private String gTPLNguoiDaiDienHP;
    private String quyetDinhBoNhiemKTT;
    private String gTTTKeToanTruong;
}
