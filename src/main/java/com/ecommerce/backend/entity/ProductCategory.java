package com.ecommerce.backend.entity;

import com.ecommerce.backend.dto.ProductCategoryDTO;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@Entity
@Table(name = "PRODUCT_CATEGORY")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "CATEGORY_NAME")
    private String categoryName;

    @Column(name = "CREATED_ON")
    @CreationTimestamp
    private Date createdOn;

    @Column(name = "UPDATED_ON")
    @UpdateTimestamp
    private Date updatedOn;

    public ProductCategoryDTO getProductCategoryData(ProductCategory savedCategory) {
        return ProductCategoryDTO.builder()
                .id(this.id)
                .categoryName(this.categoryName).build();
    }

}
