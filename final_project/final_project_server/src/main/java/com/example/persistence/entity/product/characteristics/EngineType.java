package com.example.persistence.entity.product.characteristics;

import com.example.persistence.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "engine_types")
public class EngineType extends BaseEntity {

    @Column(nullable = false)
    private String engine;

    @Column(nullable = false)
    private String fuelType;
}
