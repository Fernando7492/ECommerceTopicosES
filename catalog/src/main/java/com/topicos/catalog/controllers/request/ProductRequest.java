package com.topicos.catalog.controllers.request;

import com.topicos.catalog.config.SpringApplicationContext;
import com.topicos.catalog.models.Product;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter @Setter
public class ProductRequest {
    private String name;
    private String description;
    private String image;

    private Long categoryId;

    public Product convertToModel() {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        Product product = modelMapper.map(this, Product.class);
        return product;
    }

}
