
package com.rojascorp.api.repository;

import com.rojascorp.api.model.product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<product, Integer> {
    
}
