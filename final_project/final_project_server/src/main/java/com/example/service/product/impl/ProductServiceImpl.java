package com.example.service.product.impl;

import com.example.persistence.entity.product.Product;
import com.example.persistence.repository.product.ProductRepository;
import com.example.service.product.ProductService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Entity not found"));
    }

    @Override
    public List<Product> findTop3() {
        return productRepository.findTop3ByOrderByIdAsc();
    }
}
