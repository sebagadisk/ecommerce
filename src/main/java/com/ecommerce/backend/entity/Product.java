package com.ecommerce.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.*;

@Getter
@Setter
@Entity
@Table(name= "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "QUANTITY")
    private int quantity;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( name = "PRODUCT_PRODUCT_CATEGORY", joinColumns = {
            @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")})
    private Set<ProductCategory> categories = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "PRODUCT_ID")
    private List<ProductImage> productImageList = new ArrayList<>();

    @Column(name = "CREATED_ON")
    @CreationTimestamp
    private Date createdOn;

    @Column(name = "UPDATED_ON")
    @UpdateTimestamp
    private Date updatedOn;

}
