package com.luisrrleal.vales_backend_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luisrrleal.vales_backend_springboot.entity.DistributorEntity;

@Repository
public interface DistributorRepository extends JpaRepository<DistributorEntity, Long> { }
