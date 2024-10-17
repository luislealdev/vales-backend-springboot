package com.luisrrleal.vales_backend_springboot.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private Long id;
    private String name;
    private String address;
    private String ine; // Documento de identidad
    private String curp; // Registro único de población
    private String proofOfAddress; // Comprobante de domicilio
    private Long distributorId; // Para referencia al distribuidor
}