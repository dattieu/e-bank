package com.dtu.banking.service;

import com.dtu.banking.domain.Customer;
import com.dtu.banking.dto.CreateCustomerRequest;
import com.dtu.banking.exception.DomainException;
import com.dtu.banking.repository.CustomerRepository;
import com.dtu.banking.utils.DomainMapper;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Data
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Transactional
    public void createCustomer(CreateCustomerRequest createCustomerRequest) {
        Optional<Customer> customer = customerRepository.findCustomerByPhone(createCustomerRequest.phone());

        if (customer.isPresent()) {
            throw DomainException.customerAlreadyExistsException();
        }

        customerRepository.save(DomainMapper.toCustomer(createCustomerRequest));
    }

    @Transactional(readOnly = true)
    public Customer findCustomer(String phone) {
        Optional<Customer> customer = customerRepository.findCustomerByPhone(phone);
        if (customer.isEmpty()) {
            throw DomainException.customerNotFoundException();
        }
        return customer.get();
    }
}
