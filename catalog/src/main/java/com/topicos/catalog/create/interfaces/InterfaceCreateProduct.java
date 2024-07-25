package com.topicos.catalog.create.interfaces;

import com.topicos.catalog.models.Product;

import java.util.List;
import java.util.Optional;

public interface InterfaceCreateProduct {

    List<Product> listProducts(String description);

    List<Product> listProductsByCategory(String name);

    Product saveProduct(Product entity);

    List<Product> listProducts();

    Optional<Product> findByProductId(Long id);

    void deleteProduct(Long id);

    void deleteProduct(Product entity);

    Product updateProduct(Long id, Product entity);

}
