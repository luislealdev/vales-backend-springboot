package com.luisrrleal.vales_backend_springboot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luisrrleal.vales_backend_springboot.entity.DistributorEntity;
import com.luisrrleal.vales_backend_springboot.repository.DistributorRepository;

@Service
public class DistributorService {

    @Autowired
    private DistributorRepository distributorRepository;

    // Obtener todos los distribuidores
    public List<DistributorEntity> getAllDistributors() {
        return distributorRepository.findAll();
    }

    // Crear un nuevo distribuidor
    public DistributorEntity createDistributor(DistributorEntity distributor) {
        return distributorRepository.save(distributor);
    }

    // Eliminar distribuidor
    public void deleteDistributor(Long id) {
        distributorRepository.deleteById(id);
    }
}