package com.topicos.catalog.controllers.request;

import org.modelmapper.ModelMapper;

import com.topicos.catalog.config.SpringApplicationContext;
import com.topicos.catalog.models.Category;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CategoryRequest {
    private String name;
    private String description;
    private String icon;

    private Long parent;

    public Category convertToModel(Category parent) {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        Category category = modelMapper.map(this, Category.class);
        if (parent != null){
            category.setParentId(parent.getId());
        }
        else {
            category.setParentId(null);
        }
        return category;
    }
}
