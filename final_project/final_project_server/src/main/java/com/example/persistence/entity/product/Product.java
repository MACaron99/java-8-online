package com.example.persistence.entity.product;

import com.example.persistence.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @OneToOne
    private ProductCharacteristics productCharacteristics;

    @Column(nullable = false, length = 4096)
    private String description;

    @OneToMany(mappedBy = "product")
    private Set<ProductImage> productImages;

    public Product() {
        this.productImages = new HashSet<>();
    }
}
