package com.example.facade.product;

import com.example.api.dto.response.product.ProductPdpDto;

public interface ProductPdpFacade {

    ProductPdpDto findByProductId(Long id);
}
