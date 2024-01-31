package com.example.api.controller.personal.favorites;

import com.example.api.dto.response.product.ProductPlpDto;
import com.example.facade.favorites.FavoritesFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/personal/favorites")
public class FavoritesController {

    private final FavoritesFacade favoritesFacade;

    @GetMapping("/get")
    public ResponseEntity<List<ProductPlpDto>> getProducts() {
        return ResponseEntity.ok(favoritesFacade.getFavoriteProducts());
    }

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestParam Long productId) {
        System.out.println("I am here");
        favoritesFacade.addProductToFavorites(productId);
        return ResponseEntity.ok("Product was added to favorites");
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteProduct(@RequestParam Long productId) {
        favoritesFacade.deleteProductFromFavorites(productId);
        return ResponseEntity.ok("Product was deleted from favorites");
    }
}
