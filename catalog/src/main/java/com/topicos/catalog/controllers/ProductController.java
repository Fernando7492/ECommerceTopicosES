package com.topicos.catalog.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topicos.catalog.config.RabbitMQSender;
import com.topicos.catalog.controllers.request.ProductRequest;
import com.topicos.catalog.controllers.response.ProductResponse;
import com.topicos.catalog.frontage.Catalog;
import com.topicos.catalog.models.Product;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/catalog")
public class ProductController {

    @Autowired
    private Catalog catalog;

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @PostMapping("/product")
    public Mono<Product> saveProduct(@RequestBody ProductRequest newObj) {
        Product product = newObj.convertToModel();
        product.setId(0); // ou use null se o ID for um objeto Long
        return catalog.saveProduct(product)
            .flatMap(savedProduct -> {
                return Mono.fromRunnable(() -> {
                    rabbitMQSender.sendCategoryId(savedProduct.getId());
                }).then(Mono.just(savedProduct));
            });
    }

    @GetMapping("/product")
    public Mono<List<ProductResponse>> listProducts() {
        return catalog.listProducts()
            .collectList()
            .map(products -> {
                List<ProductResponse> response = new ArrayList<>();
                for (Product p : products) {
                    response.add(new ProductResponse(p));
                }
                return response;
            });
    }

    @GetMapping("product/{id}")
    public Mono<Product> getProductById(@PathVariable Long id) {
        return catalog.findProduct(id);
    }

    @DeleteMapping("/product/{id}")
    void deleteProduct(@PathVariable long id) {
        catalog.deleteProduct(id);
    }

    @PutMapping("/product/{id}")
    Mono<Product> updateProduct(@PathVariable long id, @Validated @RequestBody ProductRequest newObj) {
        return catalog.updateProduct(id, newObj.convertToModel());
    }
}
