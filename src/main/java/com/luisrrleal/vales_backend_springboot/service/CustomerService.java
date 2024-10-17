package com.luisrrleal.vales_backend_springboot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luisrrleal.vales_backend_springboot.entity.CustomerEntity;
import com.luisrrleal.vales_backend_springboot.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Obtener todos los clientes
    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Crear un nuevo cliente
    public CustomerEntity createCustomer(CustomerEntity customer) {
        return customerRepository.save(customer);
    }

    // Eliminar cliente
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}