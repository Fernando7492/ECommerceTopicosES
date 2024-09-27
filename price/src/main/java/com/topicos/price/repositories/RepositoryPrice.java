package com.topicos.price.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import com.topicos.price.models.Price;

public interface RepositoryPrice extends ReactiveCrudRepository<Price, Long> {
    
    Flux<Price> findByProductId(Long productId);  // Retorna um Flux reativo para múltiplos preços
    
    Flux<Price> findByPolicyId(Long policyId);  // Retorna um Flux reativo para múltiplos preços associados a uma Policy
}