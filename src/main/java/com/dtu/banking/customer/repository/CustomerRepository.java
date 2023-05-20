package com.dtu.banking.customer.repository;

import com.dtu.banking.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findCustomerByName(String name);

    Optional<Customer> findCustomerByPhone(String phone);

}
