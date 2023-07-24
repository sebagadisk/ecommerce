package com.ecommerce.backend.controller;

import com.ecommerce.backend.dto.ProductDTO;
import com.ecommerce.backend.entity.Product;
import com.ecommerce.backend.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
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
   @GetMapping("/public/products")
    private ResponseEntity<Page<Product>> getAllProductPageable(Pageable pageable){
       Page<Product> allProductPageable = productService.getAllProductPageable(pageable);
       return new ResponseEntity<>(allProductPageable, HttpStatus.OK);
   }
   @GetMapping("/public/product/{id}")
    private ResponseEntity<ProductDTO> getProductById(@PathVariable Long id){
       ProductDTO productDTObyId = productService.getById(id);
       return new ResponseEntity<>(productDTObyId, HttpStatus.OK);
   }

}
