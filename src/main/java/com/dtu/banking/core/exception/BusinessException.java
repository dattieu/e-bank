package com.dtu.banking.core.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BusinessException extends RuntimeException {

    private String errorCode;

    private String errorMessage;
}
