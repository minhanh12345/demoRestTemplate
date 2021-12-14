package com.example.demo.dto;

import lombok.Data;

import javax.persistence.*;


@Data
public class FileGiayToBatBuoc {

    private String tinhThanhPho;
    private String quanHuyen;
    private String chiNhanh;
    private String diaChi;
    private String sdt;

}
