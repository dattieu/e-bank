package com.dtu.banking.utils;

import com.dtu.banking.domain.Customer;
import com.dtu.banking.dto.CreateCustomerRequest;
import org.springframework.beans.BeanUtils;

public final class DomainMapper {

    public static Customer toCustomer(CreateCustomerRequest createCustomerRequest) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(createCustomerRequest, customer);
        return customer;
    }
}
