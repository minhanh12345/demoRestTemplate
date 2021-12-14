package com.example.demo.repo;

import com.example.demo.entity.TaiKhoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaiKhoanRepo extends JpaRepository<TaiKhoanEntity,Long> {
}
