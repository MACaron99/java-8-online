package com.example.facade.product.impl;

import com.example.api.dto.response.product.ProductPdpDto;
import com.example.facade.product.ProductPdpFacade;
import com.example.service.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductPdpFacadeImpl implements ProductPdpFacade {

    private final ProductService productService;

    @Override
    public ProductPdpDto findByProductId(Long id) {
        return new ProductPdpDto(productService.findById(id));
    }
}
