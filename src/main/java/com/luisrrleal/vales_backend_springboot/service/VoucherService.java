package com.luisrrleal.vales_backend_springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luisrrleal.vales_backend_springboot.dto.VoucherDTO;
import com.luisrrleal.vales_backend_springboot.entity.VoucherEntity;
import com.luisrrleal.vales_backend_springboot.repository.VoucherRepository;

@Service
public class VoucherService {

    @Autowired
    private VoucherRepository voucherRepository;

    // Método para obtener todos los vouchers
    public List<VoucherEntity> getAllVouchers() {
        return voucherRepository.findAll();
    }

    // Método para crear un nuevo voucher
    public VoucherEntity createVoucher(VoucherDTO voucherDTO) {
        VoucherEntity voucher = new VoucherEntity();
        voucher.setCode(voucherDTO.getCode());
        voucher.setAmount(voucherDTO.getAmount());
        voucher.setCreationDate(voucherDTO.getCreationDate());
        voucher.setDueDate(voucherDTO.getDueDate());
        // Lógica adicional para asociar al cliente

        return voucherRepository.save(voucher);
    }

    // Método para encontrar un voucher por código
    public Optional<VoucherEntity> findByCode(String code) {
        return voucherRepository.findByCode(code);
    }

    // Método para eliminar un voucher
    public void deleteVoucher(Long id) {
        voucherRepository.deleteById(id);
    }
}