package com.topicos.catalog.controllers.response;

import com.topicos.catalog.config.SpringApplicationContext;
import com.topicos.catalog.models.Category;
import org.modelmapper.ModelMapper;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CategoryResponse {

    private long id;
    private String name;
    private String description;
    private String icon;
    private Category parent;

    public CategoryResponse(Category category) {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        modelMapper.map(category, this);
    }
}
