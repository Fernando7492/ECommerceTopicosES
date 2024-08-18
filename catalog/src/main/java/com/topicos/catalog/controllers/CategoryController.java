package com.topicos.catalog.controllers;

import com.topicos.catalog.controllers.request.CategoryRequest;
import com.topicos.catalog.controllers.response.CategoryResponse;
import com.topicos.catalog.frontage.Catalog;
import com.topicos.catalog.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private Catalog catalog;

    @PostMapping("/category")
    Category saveCategory(@Validated @RequestBody CategoryRequest newObj) {
        return catalog.saveCategory(newObj.convertToModel());
    }

    @GetMapping("/category")
    List<CategoryResponse> listCategories() {
        List<CategoryResponse> response = new ArrayList<CategoryResponse>();
        for(Category c : catalog.listCategories())
            response.add(new CategoryResponse(c));
        return response;
    }

    @GetMapping("/category/{id}")
    CategoryResponse listCategory(@PathVariable long id) {
        return new CategoryResponse(catalog.findCategory(id));
    }

    @DeleteMapping("/category/{id}")
    ResponseEntity<?> deleteCategory(@PathVariable long id) {
        catalog.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/category/{id}")
    Category updateCategory(@PathVariable long id, @Validated @RequestBody CategoryRequest newObj) {
        return catalog.updateCategory(id, newObj.convertToModel());
    }
}
