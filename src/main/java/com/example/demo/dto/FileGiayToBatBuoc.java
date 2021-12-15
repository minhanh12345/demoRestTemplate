package com.example.demo.dto;

import lombok.Data;

import javax.persistence.*;


@Data
public class FileGiayToBatBuoc {

    private String giayChungNhanDKKD;
    private  String giayUyQuyenNguoiDaiDienPL;
    private String gTPLNguoiDaiDienHP;
    private String quyetDinhBoNhiemKTT;
    private String gTTTKeToanTruong;

}
