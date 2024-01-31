package com.example.facade.product.impl;

import com.example.api.dto.response.product.ProductPlpDto;
import com.example.facade.product.ProductPlpFacade;
import com.example.service.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductPlpFacadeImpl implements ProductPlpFacade {

    private final ProductService productService;

    @Override
    public List<ProductPlpDto> findAll() {
        return productService.findAll()
                .stream()
                .map(ProductPlpDto::new)
                .toList();
    }

    @Override
    public List<ProductPlpDto> findTop3() {
        return productService.findTop3()
                .stream()
                .map(ProductPlpDto::new)
                .toList();
    }
}
