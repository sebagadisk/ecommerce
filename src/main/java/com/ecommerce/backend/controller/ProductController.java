package com.ecommerce.backend.controller;

import com.ecommerce.backend.dto.ProductDTO;
import com.ecommerce.backend.entity.Product;
import com.ecommerce.backend.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProductController {

   private final ProductService productService;

   @PostMapping("/user/product")
    private ResponseEntity<Product> saveOrUpdate(@RequestBody ProductDTO productDTO){
       Product product = null;
       if(productDTO.getId() == null){
           product = productService.saveProduct(productDTO);
       }else{
           product = productService.updateProduct(productDTO);
       }
       return  new ResponseEntity<>(product, HttpStatus.OK);
   }

}
