package com.topicos.price;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class PriceController {
    
    @GetMapping("/")
    public String index() {
        return "Hello from PriceController";
    }
}
