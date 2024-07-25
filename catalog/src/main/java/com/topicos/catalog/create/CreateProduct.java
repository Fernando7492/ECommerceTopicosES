package com.topicos.catalog.create;

import com.topicos.catalog.create.interfaces.InterfaceCreateProduct;
import com.topicos.catalog.models.Product;
import com.topicos.catalog.repositories.RepositoryProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CreateProduct implements InterfaceCreateProduct {

    @Autowired
    private RepositoryProduct repositoryProduct;

    @Override
    public List<Product> listProducts(String description) {
        return repositoryProduct.findByDescriptionContainingIgnoreCase(description);
    }

    @Override
    public List<Product> listProductsByCategory(String name) {
        return repositoryProduct.findByCategory_name(name);
    }

    @Override
    public  Product saveProduct(Product entity) {
        return repositoryProduct.save(entity);
    }

    @Override
    public List<Product> listProducts() {
        return repositoryProduct.findAll();
    }

    @Override
    public Optional<Product> findByProductId(Long id) {
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
}
