package com.ecommerce.backend.controller;

import com.ecommerce.backend.dto.ProductDTO;
import com.ecommerce.backend.entity.Product;
import com.ecommerce.backend.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
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
   @Operation(summary = "save product ", description = "this api will take productdto as a requestbody and return " +
           "product", tags = "USER APIs")
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
   @Operation(summary = "get all products ", description = "this api will give us all products"
           , tags = "PUBLIC APIs")
    private ResponseEntity<Page<Product>> getAllProductPageable(Pageable pageable){
       Page<Product> allProductPageable = productService.getAllProductPageable(pageable);
       return new ResponseEntity<>(allProductPageable, HttpStatus.OK);
   }
   @GetMapping("/public/product/{id}")
   @Operation(summary = "get product by id ", description = "this api will give us product by id"
           , tags = "PUBLIC APIs")
    private ResponseEntity<ProductDTO> getProductById(@PathVariable Long id){
       ProductDTO productDTObyId = productService.getById(id);
       return new ResponseEntity<>(productDTObyId, HttpStatus.OK);
   }

    @GetMapping("/user/product/{id}/delete")
    @Operation(summary = "delete product by id", description = "this api will delete product by id from db" ,
            tags = "USER APIs")
    private ResponseEntity<?> deleteProductById(@PathVariable("id") Long id){
        try{
            productService.deleteProductById(id);
            return ResponseEntity.noContent().build();
        }catch (EmptyResultDataAccessException ex){
            return ResponseEntity.notFound().build();

        }

    }

}
