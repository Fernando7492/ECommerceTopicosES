package com.topicos.catalog.controllers.request;

import com.topicos.catalog.config.SpringApplicationContext;
import com.topicos.catalog.models.Category;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

import org.modelmapper.ModelMapper;

@Getter @Setter
public class CategoryRequest {
    private String name;
    private String description;
    private String icon;

    private Long parent;

    public Category convertToModel(Category parent) {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        Category category = modelMapper.map(this, Category.class);
        category.setParent(parent);
        return category;
    }

    //Alerta de lambança !!!
    public Category convertToModel(Optional<Category> category) {
        // TODO Auto-generated method stub
        //Metodo temporario só pra dar suporte a optional para que a função update votle a funcionar.
        //Para resolver isso, é necessário implementar um método que converta um Optional<Category> para Category
        //ToDo
        throw new UnsupportedOperationException("Unimplemented method 'convertToModel'");
    }
}
