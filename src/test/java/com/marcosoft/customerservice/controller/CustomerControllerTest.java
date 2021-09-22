package com.marcosoft.customerservice.controller;

import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import com.marcosoft.customerservice.entity.Customer;
import com.marcosoft.customerservice.repository.CustomerRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {
    
    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    public void shouldCreateCustomer() {
        var customer = Customer.builder()
            .name("Carlos")
            .birthDate(LocalDate.now())
            .email("bla@blu.org")
            .build();
        customerController.create(customer);
        
        verify(customerRepository).save(customer);
    }
}
