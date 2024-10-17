package com.luisrrleal.vales_backend_springboot;

public class AuthenticationResponse {
    private String jwt;
    private Long distributorId;

    public AuthenticationResponse(String jwt, Long distributorId) {
        this.jwt = jwt;
        this.distributorId = distributorId;
    }

    // Getters y setters
    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public Long getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(Long distributorId) {
        this.distributorId = distributorId;
    }
}
