package com.ecommerce.backend.service.Implementation;

import com.ecommerce.backend.entity.Product;
import com.ecommerce.backend.repository.ProductRepository;
import com.ecommerce.backend.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImplementation implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        Product newProduct = new Product();
        newProduct.setName(product.getName());
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(product.getPrice());
        newProduct.setQuantity(product.getQuantity());
        newProduct.setCategories(product.getCategories());
        newProduct.setProductImageList(product.getProductImageList());
        Product savedProduct = productRepository.save(newProduct);
        return savedProduct;
    }

    @Override
    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getId()).get();
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setCategories(product.getCategories());
        existingProduct.setProductImageList(product.getProductImageList());
        Product updatedProduct = productRepository.save(existingProduct);
        return updatedProduct;
    }

    @Override
    public Page<Product> getAllProductPageable(Pageable pageable) {
        Page<Product> allProduct = productRepository.findAll(pageable);
        return allProduct;
    }

    @Override
    public Product getById(Long id) {
        Product productDetail = productRepository.findById(id).get();
        return productDetail;
    }
}
