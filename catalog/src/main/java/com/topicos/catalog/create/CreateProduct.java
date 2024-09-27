package com.topicos.catalog.create;

import com.topicos.catalog.create.exception.DuplicatedRegisterException;
import com.topicos.catalog.create.interfaces.InterfaceCreateProduct;
import com.topicos.catalog.models.Product;
import com.topicos.catalog.repositories.RepositoryProduct;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProduct implements InterfaceCreateProduct {

    @Autowired
    private RepositoryProduct repositoryProduct;

    @Override
    public Mono<Product> saveProduct(Product entity) {
        return repositoryProduct.findByNameContainingIgnoreCase(entity.getName())
            .flatMap(existingProduct -> Mono.<Product>error(new DuplicatedRegisterException("Já existe um produto com o nome [" + entity.getName() + "] cadastrado no sistema.")))
            .switchIfEmpty(repositoryProduct.save(entity)); // Salva o produto se não existir
    }

    @Override
    public Flux<Product> listProducts() {
        return repositoryProduct.findAll();
    }

    @Override
    public Flux<Product> listProducts(String description) {
        return repositoryProduct.findByDescriptionContainingIgnoreCase(description);
    }

    @Override
    public Mono<Product> findByProductId(Long id) {
        return repositoryProduct.findById(id);
    }

    @Override
    public void deleteProduct(Long id) {
        repositoryProduct.deleteById(id);
    }

    @Override
    public void deleteProduct(Product entity) {
        repositoryProduct.delete(entity);
    }

    @Override
    public Mono<Product> updateProduct(Long id, Product entity) {
        Product product = findByProductId(id).block();
        if (product == null) {
            return Mono.error(new IllegalArgumentException("Product with id " + id + " not found"));
        }
        product.setName(entity.getName());
        product.setDescription(entity.getDescription());
        product.setCategoryId(entity.getCategoryId());
        return repositoryProduct.save(product);
    }
}
