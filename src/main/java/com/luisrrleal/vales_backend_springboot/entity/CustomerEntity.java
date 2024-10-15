package com.luisrrleal.vales_backend_springboot.entity;

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
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(unique = true)
    private String ine;

    @Column(unique = true)
    private String curp;

    @Column(nullable = false)
    private String addressProof;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<VoucherEntity> vouchers;

    @ManyToOne
    @JoinColumn(name = "distributor_id") // Foreign key en la tabla de clientes
    private DistributorEntity distributor;

}
