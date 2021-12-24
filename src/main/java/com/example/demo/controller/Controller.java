package com.example.demo.controller;

import com.example.demo.dto.ThongTinChung;
import com.example.demo.entity.ThongTinChungEntity;
import com.example.demo.service.ThongTinChungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    ThongTinChungService thongTinChungService;
    @PostMapping("/save")
    public ResponseEntity<ThongTinChungEntity> save(@RequestBody ThongTinChung thongTinChung){
        return new ResponseEntity<>(thongTinChungService.save(thongTinChung), HttpStatus.OK);
    }
    @GetMapping("/get{id}")
    public ResponseEntity<ThongTinChung> get(@PathVariable Long id){
        return new ResponseEntity<>(thongTinChungService.getById(id), HttpStatus.OK);
    }
    @PostMapping("/update{id}")
    public ResponseEntity<ThongTinChungEntity> save(@RequestBody ThongTinChung thongTinChung,@PathVariable Long id){
        return new ResponseEntity<>(thongTinChungService.update(thongTinChung,id), HttpStatus.OK);
    }
}
