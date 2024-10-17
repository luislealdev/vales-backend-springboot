package com.luisrrleal.vales_backend_springboot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luisrrleal.vales_backend_springboot.entity.PaymentEntity;
import com.luisrrleal.vales_backend_springboot.repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    // Obtener todos los pagos
    public List<PaymentEntity> getAllPayments() {
        return paymentRepository.findAll();
    }

    // Crear un nuevo pago
    public PaymentEntity createPayment(PaymentEntity payment) {
        return paymentRepository.save(payment);
    }

    // Eliminar pago
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}