package com.topicos.catalog.create.interfaces;

import com.topicos.catalog.models.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InterfaceCreateProduct {

    Flux<Product> listProducts(String description);

    Mono<Product> saveProduct(Product entity);

    Flux<Product> listProducts();

    Mono<Product> findByProductId(Long id);

    void deleteProduct(Long id);

    void deleteProduct(Product entity);

    Mono<Product> updateProduct(Long id, Product entity);

}
