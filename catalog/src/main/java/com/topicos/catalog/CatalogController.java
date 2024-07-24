package com.topicos.catalog;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class CatalogController {
    
    @GetMapping("/")
    public String index() {
        return "Hello from CatalogController";
    }
}
