package com.ecommerce.backend.controller;

import com.ecommerce.backend.dto.ProductCategoryDTO;
import com.ecommerce.backend.entity.ProductCategory;
import com.ecommerce.backend.service.ProductCategoryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    @PostMapping("/admin/product-category/save")
    @Operation(summary = "Save Category", description = "this api will take product category as request body " +
            "and return product category details", tags = "ADMIN APIs")
    private ResponseEntity<ProductCategoryDTO> saveProductCategory(@RequestBody ProductCategory productCategory) {
        ProductCategoryDTO productCategoryDTO = productCategoryService.saveProductCategory(productCategory);
        return new ResponseEntity<>(productCategoryDTO, HttpStatus.CREATED);
    }


    @GetMapping("/public/categories")
    @Operation(summary = "get all category", description = "this api will get all category from db "
            , tags = "PUBLIC APIs")
    private ResponseEntity<List<ProductCategory>> getAllCategory() {
        List<ProductCategory> allCategory = productCategoryService.getAllCategory();
        return new ResponseEntity<>(allCategory, HttpStatus.OK);
    }

    @GetMapping("/public/category/{id}")
    @Operation(summary = "get category by id", description = "this api will get category by id from db "
            , tags = "PUBLIC APIs")
    private ResponseEntity<ProductCategoryDTO> showCategoryById(@PathVariable("id") Long id) {
        ProductCategoryDTO getById = productCategoryService.getById(id);
        return new ResponseEntity<>(getById, HttpStatus.OK);
    }

    @GetMapping("/admin/category/{id}/delete")
    @Operation(summary = "delete category by id", description = "this api will delete category by id from db" ,
                tags = "ADMIN APIs")
    private ResponseEntity<?> deleteCategoryById(@PathVariable("id") Long id){
        try{
        productCategoryService.deleteById(id);
        return ResponseEntity.noContent().build();
        }catch (EmptyResultDataAccessException ex){
            return ResponseEntity.notFound().build();

        }

}
}
