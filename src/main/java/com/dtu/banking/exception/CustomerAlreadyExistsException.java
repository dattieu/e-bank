package com.dtu.banking.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAlreadyExistsException extends RuntimeException {

    private String errorCode;

    private String errorMessage;
}
