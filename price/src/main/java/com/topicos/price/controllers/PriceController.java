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
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/price")
public class PriceController {

    @Autowired
    private PriceFrontage pricefrontage;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Value("${app.catalog-service.host}")
    private String catalogUrl;

    @PostMapping("/price")
    public Mono<Price> savePrice(@Validated @RequestBody PriceRequest newObj) {
        String urlProduct = catalogUrl + "/product/" + newObj.getProductId();

        // Usando WebClient para chamadas reativas a outro serviço
        return webClientBuilder.build()
            .get()
            .uri(urlProduct)
            .retrieve()
            .bodyToMono(ProductDTO.class)
            .switchIfEmpty(Mono.error(new ObjectNotFoundException("Product with id " + newObj.getProductId() + " not found")))
            .flatMap(product -> pricefrontage.savePrice(newObj.convertModel()));
    }

    @GetMapping("/price")
    public Flux<PriceResponse> listPrices() {
        return pricefrontage.listPrices()
            .map(PriceResponse::new);  // Converte Price em PriceResponse de forma reativa
    }

    @GetMapping("/price/{id}")
    public Mono<PriceResponse> listPrice(@PathVariable long id) {
        return pricefrontage.findPrice(id)
            .map(PriceResponse::new);  // Converte Price em PriceResponse de forma reativa
    }

    @DeleteMapping("/price/{id}")
    public Mono<ResponseEntity<Void>> deletePrice(@PathVariable long id) {
        return pricefrontage.deletePrice(id)
            .then(Mono.just(new ResponseEntity<>(HttpStatus.OK)));
    }

    @PutMapping("/price/{id}")
    public Mono<Price> updatePrice(@PathVariable long id, @Validated @RequestBody PriceRequest newObj) {
        return pricefrontage.updatePrice(id, newObj.convertModel());
    }
}
