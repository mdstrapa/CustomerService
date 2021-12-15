package com.marcosoft.customerservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import com.marcosoft.customerservice.entity.Customer;
import com.marcosoft.customerservice.repository.CustomerRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {
    
    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerRepository customerRepository;

    private Customer buildFakeCustomer(){
        return Customer.builder()
                .name("Carlos")
                .birthDate(LocalDate.now())
                .email("bla@blu.org")
                .build();
    }

    @Test
    public void shouldCreateCustomer() {
        var customer = buildFakeCustomer();
        customerController.create(customer);
        verify(customerRepository).save(customer);
    }

    @Test
    public void shouldReturnOneCustomer(){
        var expectedCustomer = buildFakeCustomer();
        Integer customerId = 1;
        when(customerRepository.findById(any())).thenReturn(Optional.of(buildFakeCustomer()));
        ResponseEntity<Customer> receivedCustomer = customerController.getCustomer(customerId);
        assertEquals(expectedCustomer,receivedCustomer.getBody());
        assertEquals(HttpStatus.OK,receivedCustomer.getStatusCode());
    }

    @Test
    public void shouldReturnNoContentWhenNoCustomerIsPresent(){
        when(customerRepository.findById(any())).thenReturn(Optional.empty());
        Integer customerId = 1;
        ResponseEntity<Customer> receivedCustomer = customerController.getCustomer(customerId);
        assertEquals(null,receivedCustomer.getBody());
        assertEquals(HttpStatus.NO_CONTENT,receivedCustomer.getStatusCode());
    }


}
