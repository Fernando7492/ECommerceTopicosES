package com.topicos.price.create.interfaces;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.topicos.price.models.Price;

public interface InterfaceCreatePrice {
    Mono<Price> savePrice(Price entity); // Operação assíncrona de salvar
    Mono<Price> updatePrice(Long id, Price entity); // Operação assíncrona de atualização
    Mono<Price> findPrice(Long id); // Busca assíncrona de uma única entidade
    Mono<Void> deletePrice(Long id); // Deleção assíncrona por ID
    Mono<Void> deletePrice(Price entity); // Deleção assíncrona de uma entidade
    Flux<Price> listPrices(); // Retorna múltiplos preços de forma reativa
}