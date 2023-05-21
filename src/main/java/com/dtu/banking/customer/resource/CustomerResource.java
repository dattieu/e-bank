package com.dtu.banking.customer.resource;

import com.dtu.banking.customer.domain.Customer;
import com.dtu.banking.customer.dto.CreateCustomerRequest;
import com.dtu.banking.customer.dto.CreateCustomerResponse;
import com.dtu.banking.customer.dto.FindCustomerResponse;
import com.dtu.banking.core.exception.BusinessException;
import com.dtu.banking.core.exception.DomainException;
import com.dtu.banking.customer.service.CustomerService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@Slf4j
@Data
public class CustomerResource {

    private final CustomerService customerService;

    @PostMapping("/customers")
    public ResponseEntity<CreateCustomerResponse> createCustomer(@Valid @RequestBody CreateCustomerRequest createCustomerRequest) {
        log.info("REST request to create a new customer with phone: {}", createCustomerRequest.phone());
        try {
            customerService.createCustomer(createCustomerRequest);
        }
        catch (BusinessException exception) {
            log.error("Failed to create customer with exception: {}", exception.getMessage());
            return ResponseEntity.badRequest().body(CreateCustomerResponse.failure(DomainException.CUSTOMER_ALREADY_EXISTS_ERROR_MESSAGE));
        }
        return ResponseEntity.ok().body(CreateCustomerResponse.success());
    }

    @GetMapping("/customers")
    public ResponseEntity<FindCustomerResponse> findCustomer(@Valid @RequestParam(value = "phone") String phone) {
        log.info("REST request to find customer with phone: {}", phone);
        Customer customer;
        try {
            customer = customerService.findCustomer(phone);
        }
        catch (BusinessException exception) {
            log.error("Failed to find customer with exception: {}", exception.getMessage());
            return ResponseEntity.badRequest().body(FindCustomerResponse.failure(DomainException.CUSTOMER_NOT_FOUND_ERROR_MESSAGE));
        }
        return ResponseEntity.ok().body(FindCustomerResponse.success(customer));
    }
}
