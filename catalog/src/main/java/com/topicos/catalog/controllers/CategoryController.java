package com.topicos.catalog.controllers;

import com.topicos.catalog.controllers.request.CategoryRequest;
import com.topicos.catalog.controllers.response.CategoryResponse;
import com.topicos.catalog.create.exception.ObjectNotFoundException;
import com.topicos.catalog.frontage.Catalog;
import com.topicos.catalog.models.Category;

import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CategoryController {
    @Autowired
    private Catalog catalog;

    @PostMapping("/category")
    public Mono<Category> saveCategory(@Validated @RequestBody CategoryRequest newObj) {
        Category parent = null;
        if (newObj.getParent() != null) {
            parent = catalog.findCategory(newObj.getParent()).blockOptional().orElseThrow(() -> new ObjectNotFoundException("Categoria pai não encontrada"));
        }

        Category category = newObj.convertToModel(parent);
        
        return catalog.saveCategory(category);
    }

    @GetMapping("/category")
    public Mono<List<CategoryResponse>> listCategories() {
        return catalog.listCategories()
                .collectList()
                .map(categories -> {
                    List<CategoryResponse> response = new ArrayList<>();
                    for (Category c : categories) {
                        response.add(new CategoryResponse(c));
                    }
                    return response;
                });
    }

    @GetMapping("/category/{id}")
    public Mono<ResponseEntity<CategoryResponse>> listCategory(@PathVariable long id) {
        return catalog.findCategory(id)
                .map(category -> ResponseEntity.ok(new CategoryResponse(category)))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/category/{id}")
    ResponseEntity<?> deleteCategory(@PathVariable long id) {
        catalog.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/category/{id}")
    public Mono<Category> updateCategory(@PathVariable long id, @Validated @RequestBody CategoryRequest newObj) {
        Mono<Category> parentCategory = catalog.findCategory(newObj.getParent());
        return parentCategory.flatMap(parent -> catalog.updateCategory(id, newObj.convertToModel(parent)));
    }
}
