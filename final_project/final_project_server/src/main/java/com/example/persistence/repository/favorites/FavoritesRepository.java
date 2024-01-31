package com.example.persistence.repository.favorites;

import com.example.persistence.entity.cart.Favorites;
import com.example.persistence.entity.product.Product;
import com.example.persistence.entity.user.Personal;
import com.example.persistence.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoritesRepository extends BaseRepository<Favorites> {

    void deleteByPersonalAndProduct(Personal personal, Product product);

    boolean existsByPersonalAndProduct(Personal personal, Product product);

    List<Favorites> findByPersonal(Personal personal);
}
