package com.relationship.onetomany.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.relationship.onetomany.model.Brand;
import com.relationship.onetomany.repository.BrandRepo;

@Service
public class BrandService {
    private BrandRepo brandRepo;
    public BrandService(BrandRepo brandRepo){
        this.brandRepo=brandRepo;
    }
    public Brand postBrand(Brand brand){
        return brandRepo.save(brand);
    }
    public Brand getBrandList(int brand_id){
        return brandRepo.findById(brand_id).orElse(new Brand());
    }
    public Brand putBrand(Brand brand){
        return brandRepo.save(brand);
    }
    public void deleteBrand(int id){
        brandRepo.findById(id);
    }
    public Page<Brand> paginationBrand(int offset,int pagesize)
    {
        return brandRepo.findAll(PageRequest.of(offset,pagesize));
    }
    public Page<Brand> pageSortBrand(int offset,int pagesize,String field)
    {
        PageRequest pageRequest=PageRequest.of(offset, pagesize , Sort.by(field));
        return brandRepo.findAll(pageRequest);
    }
}
