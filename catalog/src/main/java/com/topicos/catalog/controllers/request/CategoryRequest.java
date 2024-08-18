package com.topicos.catalog.controllers.request;

import com.topicos.catalog.config.SpringApplicationContext;
import com.topicos.catalog.create.CreateCategory;
import com.topicos.catalog.models.Category;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter @Setter
@Component
public class CategoryRequest {
    private String name;
    private String description;
    private String icon;

    private Long parentId;

    public Category convertToModel() {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        Category category = modelMapper.map(this, Category.class);
        return category;
    }
}
