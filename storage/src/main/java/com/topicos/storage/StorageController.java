package com.topicos.storage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {

    @GetMapping("/")
    public String index(){return "Hello from StorageController";}
}
