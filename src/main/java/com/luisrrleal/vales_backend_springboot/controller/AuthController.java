package com.luisrrleal.vales_backend_springboot.controller;

import com.luisrrleal.vales_backend_springboot.AuthenticationRequest;
import com.luisrrleal.vales_backend_springboot.AuthenticationResponse;
import com.luisrrleal.vales_backend_springboot.service.DistributorService;
import com.luisrrleal.vales_backend_springboot.utils.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private DistributorService distributorService;

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody AuthenticationRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Long distributorId = distributorService.getDistributorByEmail(userDetails.getUsername()).getId();

        // Genera el token con el distributorId incluido
        String jwt = jwtUtil.generateToken(userDetails, distributorId);

        return new AuthenticationResponse(jwt, distributorId);
    }
}