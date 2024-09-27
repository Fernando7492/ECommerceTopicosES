package com.topicos.price.create.interfaces;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.topicos.price.models.Policy;

public interface InterfaceCreatePolicy {
    Mono<Policy> savePolicy(Policy entity); // Retorna um Mono, pois é uma operação assíncrona única
    Mono<Policy> updatePolicy(Long id, Policy entity); // Mono para operação de atualização
    Mono<Policy> findPolicy(Long id); // Mono para busca de uma política
    Mono<Void> deletePolicy(Long id); // Mono<Void> para operação de deleção por ID
    Mono<Void> deletePolicy(Policy entity); // Mono<Void> para operação de deleção por entidade
    Flux<Policy> listPolicies(); // Flux para retornar todas as políticas de forma reativa
}