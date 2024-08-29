package com.topicos.catalog.controllers.response;

import com.topicos.catalog.config.SpringApplicationContext;
import com.topicos.catalog.models.Product;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class ProductResponse {

    private long id;
    private String name;
    private String description;
    private String image;
    private Long categoryId;

    public ProductResponse(Product product) {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        modelMapper.map(product, this);
    }
}
