package com.topicos.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ServiceController {

    @GetMapping("/public/endpoint")
    public String publicEndpoint() {
        return "Esta é uma rota pública";
    }

    @GetMapping("/protected/endpoint")
    public String protectedEndpoint() {
        return "Esta é uma rota protegida, acessível apenas com token";
    }
}