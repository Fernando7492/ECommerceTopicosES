package com.topicos.catalog.frontage;

import com.topicos.catalog.create.interfaces.InterfaceCreateCategory;
import com.topicos.catalog.create.interfaces.InterfaceCreateProduct;
import com.topicos.catalog.models.Category;
import com.topicos.catalog.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Catalog {

    @Autowired
    private InterfaceCreateCategory interfaceCreateCategory;
    @Autowired
    private InterfaceCreateProduct interfaceCreateProduct;

    public Category saveCategory(Category entity) { return interfaceCreateCategory.saveCategory(entity); }
    public List<Category> listCategories() {
        return interfaceCreateCategory.listCategories();
    }
    public void deleteCategory(Long id) {
        interfaceCreateCategory.deleteCategory(id);
    }
    public void deleteCategory(Category entity) {
        interfaceCreateCategory.deleteCategory(entity);
    }
    public Category findCategory(Long id) {
        return interfaceCreateCategory.findCategory(id);
    }
    public Category updateCategory(Long id, Category entity) {
        return interfaceCreateCategory.updateCategory(id, entity);
    }
    public List<Product> listProducts(String descricao) {
        return interfaceCreateProduct.listProducts(descricao);
    }
    public List<Product> listProductsByCategory(String nome) {
        return interfaceCreateProduct.listProductsByCategory(nome);
    }
    public Product saveProductProduct(Product entity) {
        return interfaceCreateProduct.saveProduct(entity);
    }
    public List<Product> listProducts() {
        return interfaceCreateProduct.listProducts();
    }
    public Optional<Product> findProductId(Long id) {
        return interfaceCreateProduct.findByProductId(id);
    }
    public void deleteProduct(Long id) {
        interfaceCreateProduct.deleteProduct(id);
    }
    public void deleteProduct(Product entity) {
        interfaceCreateProduct.deleteProduct(entity);
    }
    public Product updateProduct(Long id, Product entity) {
        return interfaceCreateProduct.updateProduct(id, entity);
    }
}
