package com.ecommerce.backend.service;

import com.ecommerce.backend.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    Product saveProduct(Product product);

    Product updateProduct(Product product);

    Page<Product> getAllProductPageable(Pageable pageable);

    Product getById(Long id);

}
