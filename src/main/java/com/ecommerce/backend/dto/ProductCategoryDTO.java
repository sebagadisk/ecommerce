package com.ecommerce.backend.dto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class ProductCategoryDTO {
    private Long id;
    private String categoryName;
    private Date createdOn;
}
