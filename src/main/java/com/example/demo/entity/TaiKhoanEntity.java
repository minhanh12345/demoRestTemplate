package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
public class TaiKhoanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String stk;
    private String loaiTK;
    private String loaiTien;
    private String mucDichSuDung;
    private String tenTK;
  @ManyToOne
    private ThongTinChungEntity thongTinChungEntity;
  @OneToMany
    private List<SoDienThoaiDangKyEntity> soDienThoaiDangKyList;
}
