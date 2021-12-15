package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ThongTinDiaChiToChucEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String quocGia;
    private String tinhTP;
    private String quanHuyen;
    private String phuongXa;
    private String diaChiCuThe;
    private String loaiDiaChi;

}
