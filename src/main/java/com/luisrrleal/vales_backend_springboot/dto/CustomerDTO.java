// CustomerDTO.java
package com.luisrrleal.vales_backend_springboot.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private Long id;
    private String name;
    private String address;
    private String ine;
    private String curp;
    private String proofOfAddress;
    private Long distributorId; // To reference the distributor

    // Getters and Setters
}