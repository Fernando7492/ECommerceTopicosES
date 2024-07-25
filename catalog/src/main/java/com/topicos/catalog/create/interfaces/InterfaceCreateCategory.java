package com.topicos.catalog.create.interfaces;

import com.topicos.catalog.models.Category;

import java.util.List;

public interface InterfaceCreateCategory {

    Category saveCategory(Category entity);

    Category updateCategory(Long id, Category entity);

    List<Category> listCategorys();

    void deleteCategory(Long id);

    void deleteCategory(Category entity);

    Category findCategory(Long id);
}
