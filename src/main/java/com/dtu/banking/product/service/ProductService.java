package com.dtu.banking.product.service;

import com.dtu.banking.product.domain.Product;
import com.dtu.banking.core.exception.DomainException;
import com.dtu.banking.product.repository.ProductRepository;
import lombok.Data;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Data
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Cacheable(value = "products", key = "#productId")
    @Transactional(readOnly = true)
    public Product findProduct(String productId) {
        Optional<Product> product = productRepository.findProductByProductId(productId);
        if (product.isEmpty()) {
            throw DomainException.productNotFoundException();
        }
        return product.get();
    }
}
