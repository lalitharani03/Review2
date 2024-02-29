package com.relationship.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relationship.onetomany.model.Products;

public interface ProductRepo extends JpaRepository<Products,Integer> {
    
}
