package com.luisrrleal.vales_backend_springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.luisrrleal.vales_backend_springboot.entity.DistributorEntity;

public interface DistributorRepository extends JpaRepository<DistributorEntity, Long> {
    Optional<DistributorEntity> findByEmail(String email);
}