package com.riwi.products.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.products.entities.Products;
import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Products, Long>{
    
    public List<Products> findByName(String name);
}
