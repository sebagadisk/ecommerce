package com.ecommerce.backend.service.Implementation;

import com.ecommerce.backend.dto.ProductCategoryDTO;
import com.ecommerce.backend.entity.ProductCategory;
import com.ecommerce.backend.repository.ProductCategoryRepository;
import com.ecommerce.backend.service.ProductCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductCategoryServiceImplementation implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategoryDTO saveProductCategory(ProductCategory productCategory) {
        ProductCategory newProductCategory = new ProductCategory();
        newProductCategory.setCategoryName(productCategory.getCategoryName());
        ProductCategory savedProductCategory = productCategoryRepository.save(newProductCategory);
        ProductCategoryDTO productCategoryData = savedProductCategory.getProductCategoryData(savedProductCategory);
        return productCategoryData;
    }

    @Override
    public List<ProductCategory> getAllCategory() {
        List<ProductCategory> allCategory = productCategoryRepository.findAll();
        return allCategory;
    }

    @Override
    public ProductCategory getById(Long id) {
        ProductCategory productCategory = productCategoryRepository.findById(id).get();
        return productCategory;
    }
}
