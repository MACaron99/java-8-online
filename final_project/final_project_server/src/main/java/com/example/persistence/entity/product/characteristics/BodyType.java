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
@Table(name = "body_types")
public class BodyType extends BaseEntity {

    @Column(nullable = false)
    private String bodyType;

    @Column(nullable = false)
    private Integer seatNumber;

    @Column(nullable = false)
    private String doorNumber;
}
