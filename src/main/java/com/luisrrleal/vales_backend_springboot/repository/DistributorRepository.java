package com.luisrrleal.vales_backend_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.luisrrleal.vales_backend_springboot.entity.DistributorEntity;

public interface DistributorRepository extends JpaRepository<DistributorEntity, Long> {
    // Métodos adicionales personalizados pueden añadirse aquí
}