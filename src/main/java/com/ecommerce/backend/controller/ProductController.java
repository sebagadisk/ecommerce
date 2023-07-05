package com.ecommerce.backend.controller;

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
    private ResponseEntity<Product> saveOrUpdate(@RequestBody Product productRequest){
       Product product = null;
       if(productRequest.getId() == null){
           product = productService.saveProduct(productRequest);
       }else{
           product = productService.updateProduct(productRequest);
       }
       return  new ResponseEntity<>(product, HttpStatus.OK);
   }

}
