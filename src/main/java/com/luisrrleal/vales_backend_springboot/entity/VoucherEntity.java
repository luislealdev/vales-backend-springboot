package com.luisrrleal.vales_backend_springboot.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "voucher")
public class VoucherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customer;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private LocalDate creationDate;

    @Column(nullable = false)
    private LocalDate dueDate;

    @Column(nullable = false)
    private Boolean isPaid;

    @OneToMany(mappedBy = "voucher", cascade = CascadeType.ALL)
    private List<PaymentEntity> payments;

}
