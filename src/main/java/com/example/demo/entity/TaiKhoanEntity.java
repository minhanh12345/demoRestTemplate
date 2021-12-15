package com.example.demo.entity;

import com.example.demo.dto.ThongTinTKTT;
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
  @OneToMany(cascade = {CascadeType.ALL})
    private List<SoDienThoaiDangKyEntity> soDienThoaiDangKyList;
}
