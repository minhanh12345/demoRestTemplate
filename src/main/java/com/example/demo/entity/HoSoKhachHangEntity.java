package com.example.demo.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class HoSoKhachHangEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String maHs;
    private String ghiChu;
    private String ngayYeuCau;
    private String trangThai;

    @OneToOne(cascade = {CascadeType.ALL})
    private ThongTinChungEntity thongTinChungEntity;
}
