package com.relationship.onetomany.controller;
import org.springframework.web.bind.annotation.RestController;
import com.relationship.onetomany.model.Products;
import com.relationship.onetomany.service.ProductService;
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
public class ProductController {
    private ProductService productService;
    public ProductController(ProductService productService){
        this.productService=productService;
    }
    @PostMapping("/product")
    public Products postProducts(@RequestBody Products products) {
        return productService.postProducts(products);
    }
    @GetMapping("/getproduct/{product_id}")
    public Products getListOfProducts(@PathVariable("product_id") int productId) {
        return productService.getProductList(productId);
    }
    @PutMapping("/putproduct/{id}")
    public Products putProductDetails(@PathVariable("id") int id, @RequestBody Products products) {
        return productService.putProducts(products);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteProductDetail(@PathVariable("id") int id){
         productService.deleteProduct(id);
    }
    @GetMapping("/product/{offset}/{pagesize}")
    public ResponseEntity<Page<Products>> getPaginationProducts(@PathVariable("offset") int offset,@PathVariable("pagesize") int pagesize) 
    {
        Page<Products> pro=productService.paginationProducts(offset,pagesize);
        if(pro!=null)
        {
            return new ResponseEntity<>(pro,HttpStatus.OK);
        }
        return new ResponseEntity<>(pro,HttpStatus.NOT_FOUND);
    }
    @GetMapping("/products/{offset}/{pagesize}/{field}")
    public ResponseEntity<Page<Products>> getPageSortProducts(@PathVariable("offset") int offset,@PathVariable("pagesize") int pagesize,@PathVariable("field") String field) {
        Page<Products> sort=productService.pageSortProducts(offset,pagesize,field);
        if(sort!=null){
            return new ResponseEntity<>(sort,HttpStatus.OK);
        }
        return new ResponseEntity<>(sort,HttpStatus.NOT_FOUND);
    }
}
