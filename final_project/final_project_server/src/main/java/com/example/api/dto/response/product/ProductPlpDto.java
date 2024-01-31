package com.example.api.dto.response.product;

import com.example.api.dto.response.BaseResponseDto;
import com.example.persistence.entity.product.Product;
import com.example.persistence.entity.product.ProductImage;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Set;

@Getter
@Setter
public class ProductPlpDto extends BaseResponseDto {

    private String name;
    private String image;
    private Integer price;
    private String description;

    public ProductPlpDto(Product product) {
        setId(product.getId());
        setName(product.getName());
        setPrice(product.getPrice());
        setDescription(product.getDescription());
        Set<ProductImage> images = product.getProductImages();
        if (CollectionUtils.isNotEmpty(images)) {
            ProductImage productImage = images
                    .stream()
                    .filter(ProductImage::getMainImage)
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Main image is not exist"));
            this.image = productImage.getImageUrl();
        }
    }
}
