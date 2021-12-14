package com.example.demo.dto;

import lombok.Data;

import javax.persistence.*;


@Data
public class ThongTinDiaChiToChuc {

    private String quocGia;
    private String tinhTP;
    private String quanHuyen;
    private String phuongXa;
    private String diaChiCuThe;
    private String loaiDiaChi;

}
