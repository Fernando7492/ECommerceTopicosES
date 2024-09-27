package com.topicos.catalog.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.topicos.catalog.models.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface RepositoryProduct extends ReactiveCrudRepository<Product,Long>{
    
    Mono<Product> findByName(String name);
    Mono<Product> findByNameContainingIgnoreCase(String name);
    Flux<Product> findByDescriptionContainingIgnoreCase(String description);
    Flux<Product> findByCategoryId(String name);

}
