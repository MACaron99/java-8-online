package com.example.service.product;

import com.example.persistence.entity.product.Product;
import com.example.service.BaseService;
import com.example.service.FindAllService;

import java.util.List;

public interface ProductService extends BaseService<Product>, FindAllService<Product> {

    List<Product> findTop3();
}
