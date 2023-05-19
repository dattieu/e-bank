package com.dtu.banking.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class CreateCustomerRequest implements Serializable {

    private String name;

    private String phone;

    private String address;

    public String phone() {
        return Objects.isNull(phone) ? "" : phone;
    }
}
