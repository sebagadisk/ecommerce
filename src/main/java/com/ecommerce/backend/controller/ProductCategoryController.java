package com.ecommerce.backend.controller;

import com.ecommerce.backend.dto.ProductCategoryDTO;
import com.ecommerce.backend.entity.ProductCategory;
import com.ecommerce.backend.service.ProductCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    @PostMapping("/admin/product-category/save")
    private ResponseEntity<ProductCategoryDTO> saveProductCategory(@RequestBody ProductCategory productCategory) {
        ProductCategoryDTO productCategoryDTO = productCategoryService.saveProductCategory(productCategory);
        return new ResponseEntity<>(productCategoryDTO, HttpStatus.CREATED);
    }

    @GetMapping("/public/categories")
    private ResponseEntity<List<ProductCategory>> getAllCategory() {
        List<ProductCategory> allCategory = productCategoryService.getAllCategory();
        return new ResponseEntity<>(allCategory, HttpStatus.OK);
    }

    @GetMapping("/public/category/{id}")
    private ResponseEntity<ProductCategoryDTO> showCategoryById(@PathVariable("id") Long id) {
        ProductCategoryDTO getById = productCategoryService.getById(id);
        return new ResponseEntity<>(getById, HttpStatus.OK);
    }
}
