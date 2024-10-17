package com.luisrrleal.vales_backend_springboot.repository;

import com.luisrrleal.vales_backend_springboot.entity.VoucherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VoucherRepository extends JpaRepository<VoucherEntity, Long> {
    // Método para encontrar todos los vouchers de un distribuidor
    List<VoucherEntity> findByDistributorId(Long distributorId);
    Optional<VoucherEntity> findByCode(String code);
}