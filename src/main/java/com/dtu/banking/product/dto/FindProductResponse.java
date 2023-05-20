package com.dtu.banking.product.dto;

import com.dtu.banking.core.dto.Response;
import com.dtu.banking.product.domain.Product;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Objects;

@Data
public class FindProductResponse extends Response implements Serializable {

    private String productId;

    private String productName;

    private String productVersion;

    public static FindProductResponse success(Product product) {
        FindProductResponse response = new FindProductResponse();
        response.setSuccess(true);
        BeanUtils.copyProperties(product, response);
        return response;
    }

    public static FindProductResponse failure(String message) {
        FindProductResponse response = new FindProductResponse();
        response.setSuccess(false);
        if (Objects.nonNull(message)) response.setMessage(message);
        return  response;
    }

}
