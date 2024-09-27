package com.topicos.catalog.create.interfaces;

import com.topicos.catalog.models.Category;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface InterfaceCreateCategory {

    Mono<Category> saveCategory(Category entity);

    Mono<Category> updateCategory(Long id, Category entity);

    Flux<Category> listCategories();

    void deleteCategory(Long id);

    void deleteCategory(Category entity);

    Mono<Category> findCategory(Long id);
}
