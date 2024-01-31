package com.example.persistence.repository.product;

import com.example.persistence.entity.product.Product;
import com.example.persistence.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends BaseRepository<Product> {

    List<Product> findTop3ByOrderByIdAsc();
}
