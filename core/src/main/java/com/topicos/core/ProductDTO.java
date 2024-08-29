package com.topicos.core;

import lombok.Data;

@Data
public class ProductDTO {

    private long id;
    private String name;
    private String description;
    private String image;
    private Long categoryId;
}
