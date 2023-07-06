package com.ecommerce.backend.service;

import com.ecommerce.backend.dto.ProductDTO;
import com.ecommerce.backend.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    Product saveProduct(ProductDTO productDTO);

    Product updateProduct(ProductDTO productDTO);

    Page<Product> getAllProductPageable(Pageable pageable);

    Product getById(Long id);

}
