package com.marcosoft.customerservice.controller;

import com.marcosoft.customerservice.entity.Customer;
import com.marcosoft.customerservice.repository.CustomerRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository repository;

    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        return repository.save(customer);
    }


    @GetMapping
    public ResponseEntity<Customer> getCustomer(@RequestParam Integer customerId){
        return repository.findById(customerId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }
    
}
