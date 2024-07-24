package com.topicos.catalog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.topicos.catalog.models.Product;


public interface RepositoryProduct extends JpaRepository<Product,Long>{
    
    List<Product> findByNameContainingIgnoreCase(String name);
    List<Product> findByDescriptionContainingIgnoreCase(String description);
    List<Product> findByCategory_name(String name);

}
