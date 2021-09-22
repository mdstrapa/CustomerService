package com.marcosoft.customerservice.repository;

import com.marcosoft.customerservice.entity.Customer;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
