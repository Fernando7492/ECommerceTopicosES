package com.topicos.catalog.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.topicos.catalog.models.Category;
import java.util.List;

@Repository
public interface RepositoryCategory extends JpaRepository<Category,Long>{
    Category findByNameIgnoreCase(String name);

    List<Category> findByDescriptionContainingIgnoreCase(String description);

    List<Category> findByParentIsNull();

    List<Category> findByParent(Category parentCategory);

    List<Category> findByParent_Id(Long parentId);

}
