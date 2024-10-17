package com.luisrrleal.vales_backend_springboot.dto;

import lombok.Data;

@Data
public class DistributorDTO {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
}