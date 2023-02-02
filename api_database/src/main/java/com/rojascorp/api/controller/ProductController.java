
package com.rojascorp.api.controller;

import com.rojascorp.api.model.product;
import com.rojascorp.api.repository.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class ProductController {
    
    private final ProductService productService;
    
    @GetMapping("/product")
    public List<product>listProducts(){
        return productService.listProducts();
        
    }
    
    @GetMapping("/product/{id}")
    public ResponseEntity<product> productId(@PathVariable Integer id){
        try{
            product product = productService.productId(id);
            return ResponseEntity.ok(product);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
        
    }
    
    @PostMapping("/product")
    public void newProduct(@RequestBody product product){
        productService.saveProduct(product);
        
    }
    
    @PutMapping("/product/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody product product, @PathVariable Integer id){
        try{
            product productExists = productService.productId(id);
            productExists.setName(product.getName());
            productExists.setPrice(product.getPrice());
            productService.saveProduct(productExists);
            return new ResponseEntity<product>(product, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<product>(product, HttpStatus.NOT_FOUND);
        }
        
    }
    
    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
    }
}
