package com.dtu.banking.core.utils;

import com.dtu.banking.customer.domain.Customer;
import com.dtu.banking.customer.dto.CreateCustomerRequest;
import org.springframework.beans.BeanUtils;

public final class DomainMapper {

    public static Customer toCustomer(CreateCustomerRequest createCustomerRequest) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(createCustomerRequest, customer);
        return customer;
    }
}
