package com.ecommerce.backend.dto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductCategoryDTO {
    private Long id;
    private String categoryName;
}
