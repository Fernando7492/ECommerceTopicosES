package com.topicos.catalog.controllers;

import com.topicos.catalog.config.ConfigModelMapper;
import com.topicos.catalog.models.Product;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductController {

    @Autowired
    private Product product;

    @Autowired
    private ConfigModelMapper modelMapper;
}
