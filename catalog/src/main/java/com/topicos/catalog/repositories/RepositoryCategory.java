package com.topicos.catalog.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.topicos.catalog.models.Category;
import java.util.List;


public interface RepositoryCategory extends JpaRepository<Category,Long>{
    Category findByNameIgnoreCase(String name);

    List<Category> findByDescriptionContainingIgnoreCase(String description);

    List<Category> findByParentCategoryIsNull();

    List<Category> findByParentCategory(Category parentCategory);

    List<Category> findByParentCategory_Id(Long id);

}
