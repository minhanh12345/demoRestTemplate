package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ThongTinDangKySeanetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hoTenNgNhapLieu;
    private String soCCCDNgNhapLieu;
    private String sdtNgNhapLieu;
    private String emailNgNhapLieu;
    private String tenTruyCapDVNgNhapLieu;
    private String hoTenNgPheDuyet;
    private String soCCCDNgPheDuyet;
    private String sdtNgPheDuyet;
    private String emailNgPheDuyet;
    private String tenTruyCapDVNgPheDuyet;

}
