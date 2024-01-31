package com.example.facade.favorites.impl;

import com.example.api.dto.response.product.ProductPlpDto;
import com.example.facade.favorites.FavoritesFacade;
import com.example.service.favorites.FavoritesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FavoritesFacadeImpl implements FavoritesFacade {

    private final FavoritesService favoritesService;

    @Override
    public void addProductToFavorites(Long productId) {
        favoritesService.addProductToFavorites(productId);
    }

    @Override
    public void deleteProductFromFavorites(Long productId) {
        favoritesService.deleteProductFromFavorites(productId);
    }

    @Override
    public List<ProductPlpDto> getFavoriteProducts() {
        return favoritesService.getProducts()
                .stream()
                .map(ProductPlpDto::new)
                .collect(Collectors.toList());
    }
}
