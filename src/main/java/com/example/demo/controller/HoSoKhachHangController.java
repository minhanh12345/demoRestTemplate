package com.example.demo.controller;

import com.example.demo.dto.HoSoKhachHang;
import com.example.demo.repo.HoSoKhachHangRepo;
import com.example.demo.service.HoSoKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hosokhachhang")
public class HoSoKhachHangController {
    @Autowired
    HoSoKhachHangService hoSoKhachHangService;

    @GetMapping("/get{maHS}")
    public ResponseEntity<HoSoKhachHang> getByMaHS(@PathVariable String maHS) {

        return new ResponseEntity<>(hoSoKhachHangService.getByMaHS(maHS), HttpStatus.OK);
    }

    @DeleteMapping("/deleteById{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        hoSoKhachHangService.deleteCaseById(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteCaseByMaHS{maHS}")
    public  ResponseEntity deleteCaseByMaHS(@PathVariable String maHS){
        hoSoKhachHangService.deleteCaseByMaHS(maHS);
        return  new ResponseEntity(HttpStatus.OK);
    }
}
