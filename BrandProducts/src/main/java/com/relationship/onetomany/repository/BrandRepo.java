package com.relationship.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relationship.onetomany.model.Brand;

public interface BrandRepo extends JpaRepository<Brand,Integer> {
    
}
