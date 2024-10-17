package com.luisrrleal.vales_backend_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.luisrrleal.vales_backend_springboot.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    // Métodos adicionales personalizados pueden añadirse aquí
}