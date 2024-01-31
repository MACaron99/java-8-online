package com.example.api.dto.response.product;

import com.example.api.dto.response.BaseResponseDto;
import com.example.persistence.entity.product.Product;
import com.example.persistence.entity.product.ProductCharacteristics;
import com.example.persistence.entity.product.ProductImage;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class ProductPdpDto extends BaseResponseDto {

    private String name;
    private String price;
    private String bodyType;
    private String seatNumber;
    private String doorNumber;
    private String engine;
    private String fuelType;
    private String transmissionType;
    private String wheelDriveType;
    private String productColor;
    private String description;
    private List<String> images;

    public ProductPdpDto(Product product) {
        setId(product.getId());
        setName(product.getName());
        setPrice(String.valueOf(product.getPrice()));
        setDescription(product.getDescription());
        ProductCharacteristics productCharacteristics = product.getProductCharacteristics();
        setBodyType(productCharacteristics.getBodyType().getBodyType());
        setSeatNumber(String.valueOf(productCharacteristics.getBodyType().getSeatNumber()));
        setDoorNumber(productCharacteristics.getBodyType().getDoorNumber());
        setEngine(productCharacteristics.getEngineType().getEngine());
        setFuelType(productCharacteristics.getEngineType().getFuelType());
        setTransmissionType(productCharacteristics.getTransmission().getTransmissionType());
        setWheelDriveType(productCharacteristics.getWheelDrive().getWheelDriveType());
        setProductColor(productCharacteristics.getProductColor().getColor());
        Set<ProductImage> images = product.getProductImages();
        if (CollectionUtils.isNotEmpty(images)) {
            this.images = images.stream().map(ProductImage::getImageUrl).toList();
        }
    }
}
