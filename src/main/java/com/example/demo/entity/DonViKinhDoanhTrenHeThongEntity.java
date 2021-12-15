package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class DonViKinhDoanhTrenHeThongEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tinhThanhPho;
    private String quanHuyen;
    private String chiNhanh;
    private String diaChi;
    private String sdt;

}
