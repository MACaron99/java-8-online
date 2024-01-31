package com.example.api.controller.open.product;

import com.example.api.dto.response.product.ProductPdpDto;
import com.example.api.dto.response.product.ProductPlpDto;
import com.example.facade.product.ProductPdpFacade;
import com.example.facade.product.ProductPlpFacade;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/open/products")
@AllArgsConstructor
public class ProductController {

    private final ProductPlpFacade productPlpFacade;
    private final ProductPdpFacade productPdpFacade;

    @GetMapping("/plp")
    public ResponseEntity<List<ProductPlpDto>> findAll() {
        return ResponseEntity.ok(productPlpFacade.findAll());
    }

    @GetMapping("/plp/top")
    public ResponseEntity<List<ProductPlpDto>> findLast() {
        return ResponseEntity.ok(productPlpFacade.findTop3());
    }

    @GetMapping("/pdp/{productId}")
    public ResponseEntity<ProductPdpDto> findByProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(productPdpFacade.findByProductId(productId));
    }
}
