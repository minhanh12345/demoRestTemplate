package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
public class ThongTinTKTTEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String loaiSoTK;
    private String soPhuTK;
    private String chuKyInSoPhu;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<TaiKhoanEntity> listTaiKhoan;

}
