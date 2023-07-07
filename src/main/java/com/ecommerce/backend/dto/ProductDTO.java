package com.ecommerce.backend.dto;

import com.ecommerce.backend.entity.ProductCategory;
import com.ecommerce.backend.entity.ProductImage;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@Builder
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private int quantity;
    private int category;
    private List<ProductImage> productImageList;
    private Date createdOn;
    @JsonIgnore
    private Date updatedOn;

}
