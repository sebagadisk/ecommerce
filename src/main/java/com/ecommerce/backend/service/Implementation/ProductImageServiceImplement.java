package com.ecommerce.backend.service.Implementation;

import com.ecommerce.backend.dto.ProductImageDTO;
import com.ecommerce.backend.entity.ProductImage;
import com.ecommerce.backend.repository.ProductImageRepository;
import com.ecommerce.backend.service.ProductImageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ProductImageServiceImplement implements ProductImageService {
    private final ProductImageRepository productImageRepository;
//
//    @Override
//    public ProductImageDTO saveProductImage(ProductImage productImage) {
//        return null;
//    }

    @Override
    public List<ProductImage> getAllProductImage() {
        List<ProductImage> findAllProductImage = productImageRepository.findAll();
        return findAllProductImage;
    }

    @Override
    public ProductImage getProductImageById(int id) {
        ProductImage findImageById = productImageRepository.findById(id);

        return findImageById;
    }
}
