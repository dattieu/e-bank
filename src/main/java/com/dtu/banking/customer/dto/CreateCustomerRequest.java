package com.dtu.banking.customer.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

@Data
public class CreateCustomerRequest implements Serializable {

    @NotBlank
    private String name;

    @NotBlank
    private String phone;

    private String address;

    public String phone() {
        return Objects.isNull(phone) ? "" : phone;
    }
}
