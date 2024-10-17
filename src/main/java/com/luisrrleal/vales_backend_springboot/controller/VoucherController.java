package com.luisrrleal.vales_backend_springboot.controller;

import com.luisrrleal.vales_backend_springboot.dto.VoucherDTO;
import com.luisrrleal.vales_backend_springboot.entity.VoucherEntity;
import com.luisrrleal.vales_backend_springboot.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vouchers")
public class VoucherController {

    @Autowired
    private VoucherService voucherService;

    // Endpoint para obtener todos los vouchers
    @GetMapping
    public ResponseEntity<List<VoucherEntity>> getAllVouchers() {
        return ResponseEntity.ok(voucherService.getAllVouchers());
    }

    // Endpoint para crear un voucher
    @PostMapping
    public ResponseEntity<VoucherEntity> createVoucher(@RequestBody VoucherDTO voucherDTO) {
        VoucherEntity voucher = voucherService.createVoucher(voucherDTO);
        return ResponseEntity.ok(voucher);
    }

    // Endpoint para buscar un voucher por código
    @GetMapping("/{code}")
    public ResponseEntity<VoucherEntity> findByCode(@PathVariable String code) {
        Optional<VoucherEntity> voucher = voucherService.findByCode(code);
        return voucher.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para eliminar un voucher
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVoucher(@PathVariable Long id) {
        voucherService.deleteVoucher(id);
        return ResponseEntity.noContent().build();
    }
}