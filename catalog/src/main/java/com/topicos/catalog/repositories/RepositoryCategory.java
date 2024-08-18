package com.topicos.catalog.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.topicos.catalog.models.Category;
import java.util.List;
import java.util.Optional;

@Repository
public interface RepositoryCategory extends JpaRepository<Category,Long>{
    Category findByNameIgnoreCase(String name);

    Optional<Category> findById(Long id);

    List<Category> findByDescriptionContainingIgnoreCase(String description);

    List<Category> findByParentCategoryIsNull();

    List<Category> findByParentCategory(Category parentCategory);

    List<Category> findByParentCategory_Id(Long id);

}
