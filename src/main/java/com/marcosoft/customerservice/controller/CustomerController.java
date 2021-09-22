package com.marcosoft.customerservice.controller;

import com.marcosoft.customerservice.entity.Customer;
import com.marcosoft.customerservice.repository.CustomerRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository repository;

    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        return repository.save(customer);
    }
    
}
