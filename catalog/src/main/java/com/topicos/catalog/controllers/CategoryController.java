package com.topicos.catalog.controllers;

import com.topicos.catalog.config.ConfigModelMapper;
import com.topicos.catalog.controllers.request.CategoryRequest;
import com.topicos.catalog.controllers.response.CategoryResponse;
import com.topicos.catalog.frontage.Catalog;
import com.topicos.catalog.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private Catalog catalog;

    @Autowired
    private ConfigModelMapper modelMapper;

    @PostMapping("/categoria")
    Category cadastrarCategory (@Validated @RequestBody CategoryRequest newObj) {
        return catalog.saveCategory(newObj.convertToModel());
    }

    @GetMapping("/categoria")
    List<CategoryResponse> listarCategorys() {
        List<CategoryResponse> response = new ArrayList<CategoryResponse>();
        for(Category c : catalog.listCategorys())
            response.add(new CategoryResponse(c));
        return response;
    }

    @GetMapping("/categoria/{id}")
    CategoryResponse listCategory(@PathVariable long id) {
        return new CategoryResponse(catalog.findCategory(id));
    }
}
