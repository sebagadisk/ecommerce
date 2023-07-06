package com.ecommerce.backend.service;

import com.ecommerce.backend.dto.ProductCategoryDTO;
import com.ecommerce.backend.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    ProductCategoryDTO saveProductCategory(ProductCategory productCategory);

    List<ProductCategory> getAllCategory();

    ProductCategory getById(Long id);

}
