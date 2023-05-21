package com.dtu.banking.service;

import com.dtu.banking.core.exception.BusinessException;
import com.dtu.banking.customer.domain.Customer;
import com.dtu.banking.customer.service.CustomerService;
import com.dtu.banking.customer.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Objects;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CustomerServiceTests {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    public void testFindCustomer() {
        Customer customer = new Customer();
        customer.setPhone("123456789");
        when(customerRepository.findCustomerByPhone(anyString())).thenReturn(Optional.of(customer));

        Customer testCustomer = customerService.findCustomer("123456789");

        Assertions.assertTrue(Objects.nonNull(testCustomer));
        Assertions.assertEquals("123456789", testCustomer.getPhone());
    }

    @Test
    public void testFindCustomer_NotFound() {
        Customer customer = new Customer();
        customer.setPhone("123456789");
        when(customerRepository.findCustomerByPhone("123456789")).thenReturn(Optional.of(customer));

        Assertions.assertThrows(BusinessException.class,
                () -> customerService.findCustomer("3335678901"));
    }
}
