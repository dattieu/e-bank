package com.dtu.banking.customer.dto;

import com.dtu.banking.customer.domain.Customer;
import com.dtu.banking.core.dto.Response;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Objects;

@Data
public class FindCustomerResponse extends Response implements Serializable {

    private String name;

    private String phone;

    private String address;

    public static FindCustomerResponse success(Customer customer) {
        FindCustomerResponse response = new FindCustomerResponse();
        response.setSuccess(true);
        BeanUtils.copyProperties(customer, response);
        return response;
    }

    public static FindCustomerResponse failure(String message) {
        FindCustomerResponse response = new FindCustomerResponse();
        response.setSuccess(false);
        if (Objects.nonNull(message)) response.setMessage(message);
        return  response;
    }

}
