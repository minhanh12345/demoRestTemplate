package com.example.demo.repo;

import com.example.demo.entity.HoSoKhachHangEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HoSoKhachHangRepo extends JpaRepository<HoSoKhachHangEntity, Long> {
    HoSoKhachHangEntity findAllByMaHs(String maHS);
    HoSoKhachHangEntity findAllById(Long id);
}
