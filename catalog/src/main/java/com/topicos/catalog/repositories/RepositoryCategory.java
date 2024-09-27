package com.topicos.catalog.repositories;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.topicos.catalog.models.Category;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface RepositoryCategory extends ReactiveCrudRepository<Category, Long> {
    
    Mono<Category> findByNameIgnoreCase(String name);

    Flux<Category> findByDescriptionContainingIgnoreCase(String description);

    Flux<Category> findByParentIdIsNull();

    Flux<Category> findByParentId(Long parentId);

}
