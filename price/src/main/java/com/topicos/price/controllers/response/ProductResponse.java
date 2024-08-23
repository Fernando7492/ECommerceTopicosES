package com.topicos.price.controllers.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {
    private long id;
    private String name;
    private String description;
    private String image;
    private Long categoryId;
}
