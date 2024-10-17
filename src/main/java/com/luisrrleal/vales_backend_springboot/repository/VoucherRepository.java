package com.luisrrleal.vales_backend_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.luisrrleal.vales_backend_springboot.entity.VoucherEntity;
import java.util.Optional;

public interface VoucherRepository extends JpaRepository<VoucherEntity, Long> {
    Optional<VoucherEntity> findByCode(String code); // Consulta personalizada para encontrar un voucher por su código
}