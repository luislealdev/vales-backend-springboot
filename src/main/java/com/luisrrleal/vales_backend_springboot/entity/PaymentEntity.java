package com.luisrrleal.vales_backend_springboot.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "payment")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "voucher_id", nullable = false)
    private VoucherEntity voucher;

    @ManyToOne
    @JoinColumn(name = "distributor_id", nullable = false)
    private DistributorEntity distributor;

    @Column(nullable = false)
    private LocalDate paymentDate;

    @Column(nullable = false)
    private Double amountPaid;

    @Column(nullable = false)
    private Boolean isLate;

}