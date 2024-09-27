package com.topicos.catalog.frontage;

import com.topicos.catalog.create.interfaces.InterfaceCreateCategory;
import com.topicos.catalog.create.interfaces.InterfaceCreateProduct;
import com.topicos.catalog.models.Category;
import com.topicos.catalog.models.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Catalog {

    @Autowired
    private InterfaceCreateCategory interfaceCreateCategory;
    @Autowired
    private InterfaceCreateProduct interfaceCreateProduct;

    public Mono<Category> saveCategory(Category entity) {
        return interfaceCreateCategory.saveCategory(entity);
    }

    public Flux<Category> listCategories() {
        return interfaceCreateCategory.listCategories();
    }

    public void deleteCategory(Long id) {
        interfaceCreateCategory.deleteCategory(id);
    }

    public Mono<Category> findCategory(Long id) {
        return interfaceCreateCategory.findCategory(id);
    }

    public Mono<Category> updateCategory(Long id, Category entity) {
        return interfaceCreateCategory.updateCategory(id, entity);
    }

    public Mono<Product> saveProduct(Product entity) {
        return interfaceCreateProduct.saveProduct(entity);
    }

    public Flux<Product> listProducts() {
        return interfaceCreateProduct.listProducts();
    }

    public Mono<Product> findProduct(Long id) {
        return interfaceCreateProduct.findByProductId(id);
    }

    public void deleteProduct(Long id) {
        interfaceCreateProduct.deleteProduct(id);
    }

    public Mono<Product> updateProduct(Long id, Product entity) {
        return interfaceCreateProduct.updateProduct(id, entity);
    }
}
