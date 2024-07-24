package com.topicos.catalog.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.topicos.catalog.models.ProductCategory;
import java.util.List;


public interface RepositoryCategory extends JpaRepository<ProductCategory,Long>{
    ProductCategory findByNameIgnoreCase(String name);

    List<ProductCategory> findByDescriptionContainingIgnoreCase(String description);

    List<ProductCategory> findByParentCategoryIsNull();

    List<ProductCategory> findByParentCategory(ProductCategory parentCategory);

    List<ProductCategory> findByParentCategory_Id(Long id);

}
