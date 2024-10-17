package com.luisrrleal.vales_backend_springboot.controller;

import com.luisrrleal.vales_backend_springboot.entity.DistributorEntity;
import com.luisrrleal.vales_backend_springboot.service.DistributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/distributors")
public class DistributorController {

    @Autowired
    private DistributorService distributorService;

    // Endpoint para obtener todos los distribuidores
    @GetMapping
    public ResponseEntity<List<DistributorEntity>> getAllDistributors() {
        return ResponseEntity.ok(distributorService.getAllDistributors());
    }

    // Endpoint para crear un nuevo distribuidor
    @PostMapping
    public ResponseEntity<DistributorEntity> createDistributor(@RequestBody DistributorEntity distributor) {
        return ResponseEntity.ok(distributorService.createDistributor(distributor));
    }

    // Endpoint para eliminar un distribuidor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDistributor(@PathVariable Long id) {
        distributorService.deleteDistributor(id);
        return ResponseEntity.noContent().build();
    }
}