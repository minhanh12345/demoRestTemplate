package com.example.demo.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
public class TaiKhoan {

    private String stk;
    private String loaiTK;
    private String loaiTien;
    private String mucDichSuDung;
    private String tenTK;
    private List<String> listSoDienThoaiDangKy;
}
