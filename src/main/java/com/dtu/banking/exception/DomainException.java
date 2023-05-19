package com.dtu.banking.exception;

public final class DomainException {

    public static final String CUSTOMER_ALREADY_EXISTS_ERROR_CODE = "4CAE";
    public static final String CUSTOMER_ALREADY_EXISTS_ERROR_MESSAGE = "Customer already exists";

    public static final String CUSTOMER_NOT_FOUND_ERROR_CODE = "4CNF";
    public static final String CUSTOMER_NOT_FOUND_ERROR_MESSAGE = "Customer not found";

    public static CustomerAlreadyExistsException customerAlreadyExistsException() {
        return new CustomerAlreadyExistsException(CUSTOMER_ALREADY_EXISTS_ERROR_CODE, CUSTOMER_ALREADY_EXISTS_ERROR_MESSAGE);
    }

    public static CustomerAlreadyExistsException customerNotFoundException() {
        return new CustomerAlreadyExistsException(CUSTOMER_NOT_FOUND_ERROR_CODE, CUSTOMER_NOT_FOUND_ERROR_MESSAGE);
    }
}
