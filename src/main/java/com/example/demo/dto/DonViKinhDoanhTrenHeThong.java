package com.example.demo.dto;

import com.example.demo.entity.ThongTinChungEntity;
import lombok.Data;

import javax.persistence.*;


@Data
public class DonViKinhDoanhTrenHeThong {

    private String tinhThanhPho;
    private String quanHuyen;
    private String chiNhanh;
    private String diaChi;
    private String sdt;

}
