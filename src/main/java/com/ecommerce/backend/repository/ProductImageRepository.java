package com.ecommerce.backend.repository;

import com.ecommerce.backend.entity.ProductCategory;
import com.ecommerce.backend.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

    List<ProductImage> findAll();

    ProductImage findById(int id);
}
