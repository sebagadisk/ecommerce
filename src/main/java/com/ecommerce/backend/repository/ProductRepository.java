package com.ecommerce.backend.repository;

import com.ecommerce.backend.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAll(Pageable pageable);
    @Query(value = "SELECT * FROM PRODUCT WHERE PRODUCT.NAME LIKE %:keyword% OR PRODUCT.DESCRIPTION LIKE %:keyword% OR PRODUCT.PRICE LIKE %:keyword%", nativeQuery = true)
    Page<Product> searchProductByKeyWord(String keyword, Pageable pageable);


}
