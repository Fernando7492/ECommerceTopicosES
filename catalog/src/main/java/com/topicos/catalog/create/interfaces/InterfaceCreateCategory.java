package com.topicos.catalog.create.interfaces;

import com.topicos.catalog.models.Category;

import java.util.List;
import java.util.Optional;

public interface InterfaceCreateCategory {

    Category saveCategory(Category entity);

    Category updateCategory(Long id, Category entity);

    List<Category> listCategories();

    void deleteCategory(Long id);

    void deleteCategory(Category entity);

    Optional<Category> findCategory(Long id);
}
