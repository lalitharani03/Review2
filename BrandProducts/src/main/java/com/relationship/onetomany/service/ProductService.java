package com.relationship.onetomany.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.relationship.onetomany.model.Products;
import com.relationship.onetomany.repository.ProductRepo;

@Service
public class ProductService {
    private ProductRepo productRepo;
    public ProductService (ProductRepo productRepo){
        this.productRepo=productRepo;
    }
    public Products postProducts(Products products){
        return productRepo.save(products);
    }
    public Products getProductList(int productId){
        return productRepo.findById(productId).orElse(new Products());
    }
    public Products putProducts(Products products){
        return productRepo.save(products);
    }
    public void deleteProduct(int id){
        productRepo.deleteById(id);
    }
    public Page<Products> paginationProducts(int offset,int pagesize)
    {
        return productRepo.findAll(PageRequest.of(offset,pagesize));
    }
    public Page<Products> pageSortProducts(int offset,int pagesize,String field)
    {
        PageRequest pageRequest=PageRequest.of(offset, pagesize , Sort.by(field));
        return productRepo.findAll(pageRequest);
    }
}
