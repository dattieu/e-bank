package com.dtu.banking.core.exception;

public final class DomainException {

    public static final String CUSTOMER_ALREADY_EXISTS_ERROR_CODE = "4CAE";
    public static final String CUSTOMER_ALREADY_EXISTS_ERROR_MESSAGE = "Customer already exists";

    public static final String CUSTOMER_NOT_FOUND_ERROR_CODE = "4CNF";
    public static final String CUSTOMER_NOT_FOUND_ERROR_MESSAGE = "Customer not found";

    public static final String PRODUCT_NOT_FOUND_ERROR_CODE = "4PNF";
    public static final String PRODUCT_NOT_FOUND_ERROR_MESSAGE = "Product not found";

    public static BusinessException customerAlreadyExistsException() {
        return new BusinessException(CUSTOMER_ALREADY_EXISTS_ERROR_CODE, CUSTOMER_ALREADY_EXISTS_ERROR_MESSAGE);
    }

    public static BusinessException customerNotFoundException() {
        return new BusinessException(CUSTOMER_NOT_FOUND_ERROR_CODE, CUSTOMER_NOT_FOUND_ERROR_MESSAGE);
    }

    public static BusinessException productNotFoundException() {
        return new BusinessException(PRODUCT_NOT_FOUND_ERROR_CODE, PRODUCT_NOT_FOUND_ERROR_MESSAGE);
    }
}
