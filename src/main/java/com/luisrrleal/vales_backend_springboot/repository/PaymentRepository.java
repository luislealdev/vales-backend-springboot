package com.luisrrleal.vales_backend_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.luisrrleal.vales_backend_springboot.entity.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
    // Métodos adicionales personalizados pueden añadirse aquí
}