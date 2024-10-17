package com.luisrrleal.vales_backend_springboot.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class VoucherDTO {
    private Long id;
    private String code;
    private Double amount;
    private LocalDate creationDate;
    private LocalDate dueDate;
    private Boolean isPaid;
    private Long customerId; // Para referencia al cliente
    private List<PaymentDTO> payments; // Lista de pagos asociados al vale

    // Getters and Setters son gestionados por Lombok con la anotación @Data
}