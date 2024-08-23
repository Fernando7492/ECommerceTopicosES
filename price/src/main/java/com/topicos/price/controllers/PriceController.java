package com.topicos.price.controllers;

import java.util.ArrayList;
import java.util.List;

import com.topicos.price.controllers.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.topicos.price.controllers.request.PriceRequest;
import com.topicos.price.controllers.response.PriceResponse;
import com.topicos.price.frontage.PriceFrontage;
import com.topicos.price.models.Price;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/price")
public class PriceController {
    @Autowired
    private PriceFrontage pricefrontage;
    @Autowired
    private RestTemplate restTemplate;
    @Value("{app.catalog-service.host}")
    private String productHost;

    @PostMapping("/price")
    Price savePrice(@Validated @RequestBody PriceRequest newObj) {
        String urlProduct = productHost + "/product" + newObj.getProductId();

        try {
            restTemplate.getForObject(urlProduct, ProductResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("Product not found:" + newObj.getProductId());
        }

        return pricefrontage.savePrice(newObj.convertModel());
    }

    @GetMapping("/price")
    List<PriceResponse> listPrices() {
        List<PriceResponse> response = new ArrayList<PriceResponse>();
        for(Price p : pricefrontage.listPrices())
            response.add(new PriceResponse(p));
        return response;
    }

    @GetMapping("/price/{id}")
    PriceResponse listPrice(@PathVariable long id) {
        return new PriceResponse(pricefrontage.findPrice(id));
    }

    @DeleteMapping("/price/{id}")
    ResponseEntity<?> deletePrice(@PathVariable long id) {
        pricefrontage.deletePrice(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/price/{id}")
    Price updatePrice(@PathVariable long id, @Validated @RequestBody PriceRequest newObj) {
        return pricefrontage.updatePrice(id, newObj.convertModel());
    }
}
