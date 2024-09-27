package com.topicos.price.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.topicos.price.controllers.request.PolicyRequest;
import com.topicos.price.controllers.response.PolicyResponse;
import com.topicos.price.frontage.PriceFrontage;
import com.topicos.price.models.Policy;

@RestController
@RequestMapping("/price")
public class PolicyController {

    @Autowired
    private PriceFrontage priceFrontage;

    @GetMapping("/policy")
    public Flux<PolicyResponse> listPolicy() {
        return priceFrontage.listPolicies()
            .map(PolicyResponse::new);  // Converte Policy para PolicyResponse de forma reativa
    }

    @PostMapping("/policy")
    public Mono<Policy> savePolicy(@Validated @RequestBody PolicyRequest newObj) {
        return priceFrontage.savePolicy(newObj.convertModel());
    }

    @DeleteMapping("/policy/{id}")
    public Mono<ResponseEntity<Void>> deletePolicy(@PathVariable long id) {
        return priceFrontage.deletePolicy(id)
            .then(Mono.just(new ResponseEntity<>(HttpStatus.OK)));  // Retorna resposta após deleção reativa
    }

    @PutMapping("/policy/{id}")
    public Mono<Policy> updatePolicy(@PathVariable long id, @Validated @RequestBody PolicyRequest newObj) {
        return priceFrontage.updatePolicy(id, newObj.convertModel());
    }
}

