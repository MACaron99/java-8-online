package com.example.service.favorites.impl;

import com.example.persistence.entity.cart.Favorites;
import com.example.persistence.entity.product.Product;
import com.example.persistence.entity.user.Personal;
import com.example.persistence.repository.favorites.FavoritesRepository;
import com.example.persistence.repository.product.ProductRepository;
import com.example.persistence.repository.user.PersonalRepository;
import com.example.service.favorites.FavoritesService;
import com.example.util.SecurityUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class FavoritesServiceImpl implements FavoritesService {

    private final FavoritesRepository favoritesRepository;
    private final PersonalRepository personalRepository;
    private final ProductRepository productRepository;

    @Override
    public void addProductToFavorites(Long productId) {
        Personal personal = personalRepository
                .findByLogin(SecurityUtil.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Product product = productRepository
                .findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        if (!favoritesRepository.existsByPersonalAndProduct(personal, product)) {
            Favorites favorites = new Favorites();
            favorites.setPersonal(personal);
            favorites.setProduct(product);
            favoritesRepository.save(favorites);
        }
    }

    @Override
    public void deleteProductFromFavorites(Long productId) {
        Personal personal = personalRepository
                .findByLogin(SecurityUtil.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Product product = productRepository
                .findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        favoritesRepository.deleteByPersonalAndProduct(personal, product);
    }

    @Override
    public List<Product> getProducts() {
        Personal personal = personalRepository
                .findByLogin(SecurityUtil.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        List<Favorites> favoritesList = favoritesRepository.findByPersonal(personal);
        return favoritesList
                .stream()
                .map(Favorites::getProduct)
                .collect(Collectors.toList());
    }
}
