package com.topicos.catalog.controllers;

import com.topicos.catalog.controllers.request.CategoryRequest;
import com.topicos.catalog.controllers.response.CategoryResponse;
import com.topicos.catalog.create.exception.ObjectNotFoundException;
import com.topicos.catalog.frontage.Catalog;
import com.topicos.catalog.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/catalog")
public class CategoryController {
    @Autowired
    private Catalog catalog;

    @PostMapping("/category")
    public Category saveCategory(@Validated @RequestBody CategoryRequest newObj) {
        Category parent = null;
        if (newObj.getParent() != null) {
            parent = catalog.findCategory(newObj.getParent()).orElseThrow(() -> new ObjectNotFoundException("Categoria pai não encontrada"));
        }

        Category category = newObj.convertToModel(parent);
        
        return catalog.saveCategory(category);
    }

    @GetMapping("/category")
    List<CategoryResponse> listCategories() {
        List<CategoryResponse> response = new ArrayList<>();
        for (Category c : catalog.listCategories()) {
            response.add(new CategoryResponse(c));
        }
        return response;
    }

    @GetMapping("/category/{id}")
    CategoryResponse listCategory(@PathVariable long id) {
        Optional<Category> category = catalog.findCategory(id);
        return category.map(CategoryResponse::new).orElse(null);
    }

    @DeleteMapping("/category/{id}")
    ResponseEntity<?> deleteCategory(@PathVariable long id) {
        catalog.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/category/{id}")
    Category updateCategory(@PathVariable long id, @Validated @RequestBody CategoryRequest newObj) {
        Category parentCategory = catalog.findCategory(newObj.getParent()).orElse(null);
        return catalog.updateCategory(id, newObj.convertToModel(parentCategory));
    }
}
