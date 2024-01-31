package com.example.persistence.entity.product;

import com.example.persistence.entity.BaseEntity;
import com.example.persistence.entity.product.characteristics.*;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product_characteristics")
public class ProductCharacteristics extends BaseEntity {

    @ManyToOne
    private BodyType bodyType;

    @ManyToOne
    private EngineType engineType;

    @ManyToOne
    private ProductColor productColor;

    @ManyToOne
    private Transmission transmission;

    @ManyToOne
    private WheelDrive wheelDrive;
}
