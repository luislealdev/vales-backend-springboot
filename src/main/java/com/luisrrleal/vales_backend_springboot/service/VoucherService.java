package com.luisrrleal.vales_backend_springboot.service;

import com.luisrrleal.vales_backend_springboot.dto.VoucherDTO;
import com.luisrrleal.vales_backend_springboot.entity.VoucherEntity;
import com.luisrrleal.vales_backend_springboot.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VoucherService {

    @Autowired
    private VoucherRepository voucherRepository;

    // Obtener todos los vouchers
    public List<VoucherDTO> getAllVouchers() {
        List<VoucherEntity> vouchers = voucherRepository.findAll();
        return vouchers.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Crear un voucher
    public VoucherDTO createVoucher(VoucherDTO voucherDTO) {
        VoucherEntity voucherEntity = convertToEntity(voucherDTO);
        VoucherEntity savedVoucher = voucherRepository.save(voucherEntity);
        return convertToDto(savedVoucher);
    }

    // Encontrar un voucher por código
    public VoucherDTO findByCode(String code) {
        VoucherEntity voucher = voucherRepository.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Vale no encontrado con el código: " + code));
        return convertToDto(voucher);
    }

    // Eliminar un voucher por ID
    public void deleteVoucher(Long id) {
        voucherRepository.deleteById(id);
    }

    // Convertir Entity a DTO
    private VoucherDTO convertToDto(VoucherEntity voucherEntity) {
        VoucherDTO dto = new VoucherDTO();
        dto.setId(voucherEntity.getId());
        dto.setCode(voucherEntity.getCode());
        dto.setAmount(voucherEntity.getAmount());
        dto.setCreationDate(voucherEntity.getIssueDate());
        dto.setDueDate(voucherEntity.getExpirationDate());
        dto.setCustomerId(voucherEntity.getCustomer().getId());
        return dto;
    }

    // Convertir DTO a Entity
    private VoucherEntity convertToEntity(VoucherDTO voucherDTO) {
        VoucherEntity entity = new VoucherEntity();
        entity.setCode(voucherDTO.getCode());
        entity.setAmount(voucherDTO.getAmount());
        entity.setIssueDate(voucherDTO.getCreationDate());
        entity.setExpirationDate(voucherDTO.getDueDate());
        // Suponiendo que el cliente ya está cargado en el servicio
        return entity;
    }
}