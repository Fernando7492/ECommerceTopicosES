package com.topicos.price.frontage;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topicos.price.create.interfaces.InterfaceCreatePolicy;
import com.topicos.price.create.interfaces.InterfaceCreatePrice;
import com.topicos.price.models.Policy;
import com.topicos.price.models.Price;

@Service
public class PriceFrontage {

    @Autowired
    private InterfaceCreatePolicy interfaceCreatePolicy;
    @Autowired
    private InterfaceCreatePrice interfaceCreatePrice;

    // Métodos para Policy

    public Mono<Policy> savePolicy(Policy entity) {
        return interfaceCreatePolicy.savePolicy(entity);  // Retorna Mono<Policy>
    }

    public Mono<Policy> updatePolicy(Long id, Policy entity) {
        return interfaceCreatePolicy.updatePolicy(id, entity);  // Retorna Mono<Policy>
    }

    public Mono<Policy> findPolicy(Long id) {
        return interfaceCreatePolicy.findPolicy(id);  // Retorna Mono<Policy>
    }

    public Mono<Void> deletePolicy(Long id) {
        return interfaceCreatePolicy.deletePolicy(id);  // Retorna Mono<Void> para operações de deleção
    }

    public Mono<Void> deletePolicy(Policy entity) {
        return interfaceCreatePolicy.deletePolicy(entity);  // Retorna Mono<Void>
    }

    public Flux<Policy> listPolicies() {
        return interfaceCreatePolicy.listPolicies();  // Retorna Flux<Policy> para listas
    }

    // Métodos para Price

    public Mono<Price> savePrice(Price entity) {
        return interfaceCreatePrice.savePrice(entity);  // Retorna Mono<Price>
    }

    public Mono<Price> updatePrice(Long id, Price entity) {
        return interfaceCreatePrice.updatePrice(id, entity);  // Retorna Mono<Price>
    }

    public Mono<Price> findPrice(Long id) {
        return interfaceCreatePrice.findPrice(id);  // Retorna Mono<Price>
    }

    public Mono<Void> deletePrice(Long id) {
        return interfaceCreatePrice.deletePrice(id);  // Retorna Mono<Void>
    }

    public Mono<Void> deletePrice(Price entity) {
        return interfaceCreatePrice.deletePrice(entity);  // Retorna Mono<Void>
    }

    public Flux<Price> listPrices() {
        return interfaceCreatePrice.listPrices();  // Retorna Flux<Price>
    }

}
