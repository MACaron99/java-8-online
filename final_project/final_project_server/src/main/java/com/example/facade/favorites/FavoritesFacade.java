package com.example.facade.favorites;

import com.example.api.dto.response.product.ProductPlpDto;

import java.util.List;

public interface FavoritesFacade {

    void addProductToFavorites(Long productId);
    void deleteProductFromFavorites(Long productId);
    List<ProductPlpDto> getFavoriteProducts();
}
