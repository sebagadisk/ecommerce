package com.ecommerce.backend.entity;

import com.ecommerce.backend.dto.ProductImageDTO;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PRODUCT_IMAGE")
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    private String url;

    private boolean isPrimary;

    public ProductImageDTO getProductData(ProductImage productImage){
        return ProductImageDTO.builder()
                .url(this.url)
                .build();
    }

}
