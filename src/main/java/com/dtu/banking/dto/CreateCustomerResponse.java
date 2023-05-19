package com.dtu.banking.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class CreateCustomerResponse extends Response implements Serializable {

    public static CreateCustomerResponse failure(String message) {
        return createResponse(false, message);
    }

    public static CreateCustomerResponse success() {
        return createResponse(true, null);
    }

    private static CreateCustomerResponse createResponse(boolean success, String message) {
        CreateCustomerResponse response = new CreateCustomerResponse();
        response.setSuccess(success);
        if (Objects.nonNull(message)) response.setMessage(message);
        return  response;
    }
}
