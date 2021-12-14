package com.example.demo.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
public class ThongTinTKTT {

    private String loaiSoTK;
    private String soPhuTK;
    private String chuKyInSoPhu;

    private List<TaiKhoan> listTaiKhoan;

}
