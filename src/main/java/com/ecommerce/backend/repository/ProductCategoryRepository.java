package com.ecommerce.backend.repository;

import com.ecommerce.backend.entity.ProductCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long> {

    List<ProductCategory> findAll();

    Set<ProductCategory> findAllById(int id);

}
