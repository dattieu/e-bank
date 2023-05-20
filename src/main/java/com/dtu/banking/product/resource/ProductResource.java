package com.dtu.banking.product.resource;

import com.dtu.banking.product.domain.Product;
import com.dtu.banking.product.dto.FindProductResponse;
import com.dtu.banking.core.exception.BusinessException;
import com.dtu.banking.core.exception.DomainException;
import com.dtu.banking.product.service.ProductService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@Slf4j
@Data
public class ProductResource {

    private final ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<FindProductResponse> findProduct(@Valid @RequestParam(value = "productId") String productId) {
        log.info("REST request to find product with productId: {}", productId);
        Product product;
        try {
            product = productService.findProduct(productId);
        }
        catch (BusinessException exception) {
            log.error("Failed to find product with exception: {}", exception.getMessage());
            return ResponseEntity.badRequest().body(FindProductResponse.failure(DomainException.PRODUCT_NOT_FOUND_ERROR_MESSAGE));
        }
        return ResponseEntity.ok().body(FindProductResponse.success(product));
    }
}
