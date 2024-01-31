package com.example.persistence.entity.cart;

import com.example.persistence.entity.BaseEntity;
import com.example.persistence.entity.product.Product;
import com.example.persistence.entity.user.Personal;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "favorites")
public class Favorites extends BaseEntity {

    @ManyToOne
    private Personal personal;

    @ManyToOne
    private Product product;

    public Favorites() { }
}
