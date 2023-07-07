package com.ecommerce.backend.service;

import com.ecommerce.backend.dto.ProductImageDTO;
import com.ecommerce.backend.entity.ProductImage;

import java.util.List;

public interface ProductImageService {

//    ProductImageDTO saveProductImage(ProductImage productImage);
    List<ProductImage> getAllProductImage();

//    ProductImageDTO getProductImageById(Long id);

    ProductImage getProductImageById(int id);
}
