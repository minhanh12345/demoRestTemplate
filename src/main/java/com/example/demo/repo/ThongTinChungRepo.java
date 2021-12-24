package com.example.demo.repo;

import com.example.demo.entity.ThongTinChungEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThongTinChungRepo extends JpaRepository<ThongTinChungEntity,Long> {
    public ThongTinChungEntity findAllById(Long id);
}
