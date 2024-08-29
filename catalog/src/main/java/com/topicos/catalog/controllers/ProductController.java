package com.topicos.catalog.controllers;

import com.topicos.catalog.controllers.request.ProductRequest;
import com.topicos.catalog.controllers.response.ProductResponse;
import com.topicos.catalog.frontage.Catalog;
import com.topicos.catalog.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/catalog")
public class ProductController {

    @Autowired
    private Catalog catalog;

    @PostMapping("/product")
    Product saveProduct(@Validated @RequestBody ProductRequest newObj) {
        return catalog.saveProductProduct(newObj.convertToModel());
    }

    @GetMapping("/product")
    List<ProductResponse> listProducts() {
        List<ProductResponse> response = new ArrayList<ProductResponse>();
        for (Product p : catalog.listProducts())
            response.add(new ProductResponse(p));

        return response;
    }

    @GetMapping("/product/{id}")
    ProductResponse listProduct(@PathVariable long id) {
        Optional<Product> product = catalog.findProduct(id);
        return product.map(ProductResponse::new).orElse(null);
    }

    @DeleteMapping("/product/{id}")
    void deleteProduct(@PathVariable long id) {
        catalog.deleteProduct(id);
    }

    @PutMapping("/product/{id}")
    Product updateProduct(@PathVariable long id, @Validated @RequestBody ProductRequest newObj) {
        return catalog.updateProduct(id, newObj.convertToModel());
    }
}
