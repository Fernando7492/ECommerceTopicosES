package com.topicos.stock;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class StockController {
    
    @GetMapping("/")
    public String index() {
        return "Hello from StockController";
    }
}
