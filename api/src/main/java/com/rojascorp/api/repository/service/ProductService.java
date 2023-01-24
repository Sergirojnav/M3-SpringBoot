
package com.rojascorp.api.repository.service;

import com.rojascorp.api.model.product;
import com.rojascorp.api.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    
    public List<product>listProducts(){
        return repository.findAll();
    }
    
    public void saveProduct(product product){
        repository.save(product);
    }
    
    public product productId(Integer id){
        return repository.findById(id).get();
    }
    
    public void deleteProduct(Integer id){
        repository.deleteById(id);
    }
}
