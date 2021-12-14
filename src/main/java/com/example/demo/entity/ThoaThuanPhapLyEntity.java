package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ThoaThuanPhapLyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String doiTuongUyQuyenPL;

    private String thoiGianUyQuyenPL;

    private String noiDungUyQuyenPL;

    private String giaTriPL;

    private String quocGia;

    private String sodinhDanh;

    private String thongTinDinhDanh;
    @OneToOne
    private ThongTinChungEntity thongTinChungEntity;
}
