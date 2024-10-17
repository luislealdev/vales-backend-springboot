package com.luisrrleal.vales_backend_springboot.controller;

import com.luisrrleal.vales_backend_springboot.dto.VoucherDTO;
import com.luisrrleal.vales_backend_springboot.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vouchers")
public class VoucherController {

    @Autowired
    private VoucherService voucherService;

    // Endpoint para obtener todos los vouchers
    @GetMapping
    public ResponseEntity<List<VoucherDTO>> getAllVouchers() {
        return ResponseEntity.ok(voucherService.getAllVouchers());
    }

    // Endpoint para crear un voucher
    @PostMapping
    public ResponseEntity<VoucherDTO> createVoucher(@RequestBody VoucherDTO voucherDTO) {
        VoucherDTO voucher = voucherService.createVoucher(voucherDTO);
        return ResponseEntity.ok(voucher);
    }

    // Endpoint para buscar un voucher por código
    @GetMapping("/{code}")
    public ResponseEntity<VoucherDTO> findByCode(@PathVariable String code) {
        VoucherDTO voucher = voucherService.findByCode(code);
        return ResponseEntity.ok(voucher);
    }

    // Endpoint para eliminar un voucher
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVoucher(@PathVariable Long id) {
        voucherService.deleteVoucher(id);
        return ResponseEntity.noContent().build();
    }
}