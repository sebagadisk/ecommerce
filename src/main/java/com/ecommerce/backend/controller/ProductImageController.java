package com.ecommerce.backend.controller;

import com.ecommerce.backend.entity.ProductImage;
import com.ecommerce.backend.service.ProductImageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ProductImageController {
    private final ProductImageService productImageService;
    @GetMapping("public/productImages")
    public ResponseEntity<List<ProductImage>> getAllProductImages(){
        List<ProductImage> allProductImages = productImageService.getAllProductImage();
        return new ResponseEntity<>(allProductImages, HttpStatus.OK);

    }
    @GetMapping("public/productImage/{id}")
    public ResponseEntity<ProductImage> getProductImageById(@PathVariable int id){
        ProductImage productImageById = productImageService.getProductImageById(id);
        return new ResponseEntity<>(productImageById, HttpStatus.OK);
    }

}
