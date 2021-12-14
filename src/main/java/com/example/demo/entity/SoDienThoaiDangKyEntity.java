package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class SoDienThoaiDangKyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sdt;
    @ManyToOne
    private TaiKhoanEntity taiKhoan;
}
