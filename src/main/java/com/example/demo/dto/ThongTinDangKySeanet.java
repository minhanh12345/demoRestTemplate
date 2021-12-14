package com.example.demo.dto;

import lombok.Data;

import javax.persistence.*;


@Data
public class ThongTinDangKySeanet {

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
