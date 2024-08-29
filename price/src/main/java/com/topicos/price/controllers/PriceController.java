package com.topicos.price.controllers;

import com.topicos.core.ProductDTO;
import com.topicos.price.controllers.request.PriceRequest;
import com.topicos.price.controllers.response.PriceResponse;
import com.topicos.price.create.exception.ObjectNotFoundException;
import com.topicos.price.frontage.PriceFrontage;
import com.topicos.price.models.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/price")
public class PriceController {
    @Autowired
    private PriceFrontage pricefrontage;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${app.catalog-service.host}")
    private String catalogUrl;

    @PostMapping("/price")
    Price savePrice(@Validated @RequestBody PriceRequest newObj) {
        String urlProduct = catalogUrl + "/product/" + newObj.getProductId();

        try {
            ProductDTO product = restTemplate.getForObject(urlProduct, ProductDTO.class);

            if (product == null) {
                throw new ObjectNotFoundException("Product with id " + newObj.getProductId() + " not found");
            }

            return pricefrontage.savePrice(newObj.convertModel());

        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new ObjectNotFoundException("Product with id " + newObj.getProductId() + " not found");
            } else {
                throw e;
            }
        }
    }

    @GetMapping("/price")
    List<PriceResponse> listPrices() {
        List<PriceResponse> response = new ArrayList<>();

        for (Price p : pricefrontage.listPrices()) {
            response.add(new PriceResponse(p));
        }

        return response;
    }

    @GetMapping("/price/{id}")
    PriceResponse listPrice(@PathVariable long id) {
        return new PriceResponse(pricefrontage.findPrice(id));
    }

    @DeleteMapping("/price/{id}")
    void deletePrice(@PathVariable long id) {
        pricefrontage.deletePrice(id);
    }

    @PutMapping("/price/{id}")
    Price updatePrice(@PathVariable long id, @Validated @RequestBody PriceRequest newObj) {
        return pricefrontage.updatePrice(id, newObj.convertModel());
    }
}
