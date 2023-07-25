package com.ecommerce.backend.service.Implementation;

import com.ecommerce.backend.dto.ProductDTO;
import com.ecommerce.backend.entity.Product;
import com.ecommerce.backend.entity.ProductCategory;
import com.ecommerce.backend.exception.BadRequestException;
import com.ecommerce.backend.repository.ProductCategoryRepository;
import com.ecommerce.backend.repository.ProductRepository;
import com.ecommerce.backend.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class ProductServiceImplementation implements ProductService {

    private final ProductRepository productRepository;

    private final ProductCategoryRepository productCategoryRepository;

    @Override
    public Product saveProduct(ProductDTO productDTO) {
        Product newProduct = new Product();
        newProduct.setName(productDTO.getName());
        newProduct.setDescription(productDTO.getDescription());
        newProduct.setPrice(productDTO.getPrice());
        newProduct.setQuantity(productDTO.getQuantity());
        Set<ProductCategory> allById = productCategoryRepository.findAllById(productDTO.getCategory());
        newProduct.setCategories(allById);
        newProduct.setProductImageList(productDTO.getProductImageList());
        Product savedProduct = productRepository.save(newProduct);
        return savedProduct;
    }

    @Override
    public Product updateProduct(ProductDTO productDTO) {
        Product existingProduct = productRepository.findById(productDTO.getId()).get();
        existingProduct.setName(productDTO.getName());
        existingProduct.setDescription(productDTO.getDescription());
        existingProduct.setPrice(productDTO.getPrice());
        existingProduct.setQuantity(productDTO.getQuantity());
//        existingProduct.setCategories(productDTO.getCategories());
        existingProduct.setProductImageList(productDTO.getProductImageList());
        Product updatedProduct = productRepository.save(existingProduct);
        return updatedProduct;
    }

    @Override
    public Page<Product> getAllProductPageable(Pageable pageable) {
        Page<Product> allProduct = productRepository.findAll(pageable);
        return allProduct;
    }

    @Override
    public ProductDTO getById(Long id) {
        Product productDetail = productRepository.findById(id).orElseThrow(()->new BadRequestException("id = " + id + " not found"));
        ProductDTO convertToProductDTO = productDetail.getProductData(productDetail);
        return convertToProductDTO;
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.findById(id).orElseThrow(()-> new BadRequestException("id" + id + "not found"));
        productRepository.deleteById(id);
    }
}
