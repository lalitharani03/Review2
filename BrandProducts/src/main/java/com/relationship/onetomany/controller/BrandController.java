package com.relationship.onetomany.controller;

import org.springframework.web.bind.annotation.RestController;
import com.relationship.onetomany.model.Brand;
import com.relationship.onetomany.service.BrandService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class BrandController {
    private BrandService brandService;
    public BrandController(BrandService brandService){
        this.brandService=brandService;
    }
    @PostMapping("/brand")
    public Brand postBrandDetails(@RequestBody Brand brand) {
        return brandService.postBrand(brand);
    }
    @GetMapping("/getbrand/{brand_id}")
    public Brand getListOfBrands(@PathVariable("brand_id") int brand_id) {
        return brandService.getBrandList(brand_id);
    }
    @PutMapping("/putbrand/{id}")
    public Brand putBrandDetails(@PathVariable("id") int id, @RequestBody Brand brand) {
        return brandService.putBrand(brand);
    }
    @DeleteMapping("/deletebrand/{id}")
    public void deleteBrandDetail(@PathVariable("id")int id){
        brandService.deleteBrand(id);
    }
    @GetMapping("/brand/{offset}/{pagesize}")
    public ResponseEntity<Page<Brand>> getPaginationBrand(@PathVariable("offset") int offset,@PathVariable("pagesize") int pagesize) 
    {
        Page<Brand> b=brandService.paginationBrand(offset,pagesize);
        if(b!=null)
        {
            return new ResponseEntity<>(b,HttpStatus.OK);
        }
        return new ResponseEntity<>(b,HttpStatus.NOT_FOUND);
    }
    @GetMapping("/brand/{offset}/{pagesize}/{field}")
    public ResponseEntity<Page<Brand>> getPageSortBrand(@PathVariable("offset") int offset,@PathVariable("pagesize") int pagesize,@PathVariable("field") String field) {
        Page<Brand> sort=brandService.pageSortBrand(offset,pagesize,field);
        if(sort!=null){
            return new ResponseEntity<>(sort,HttpStatus.OK);
        }
        return new ResponseEntity<>(sort,HttpStatus.NOT_FOUND);
    }
}
