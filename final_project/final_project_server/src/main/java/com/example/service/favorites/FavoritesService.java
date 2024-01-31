package com.example.service.favorites;
import com.example.persistence.entity.product.Product;

import java.util.List;

public interface FavoritesService {

    void addProductToFavorites(Long productId);
    void deleteProductFromFavorites(Long productId);
    List<Product> getProducts();
}
