package com.example.facade.product;

import com.example.api.dto.response.product.ProductPlpDto;

import java.util.List;

public interface ProductPlpFacade {

    List<ProductPlpDto> findAll();

    List<ProductPlpDto> findTop3();
}
