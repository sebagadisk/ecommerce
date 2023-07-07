package com.ecommerce.backend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductImageDTO {
    private Long id;
    private String url;
    private boolean isPrimary;
}
