package com.topicos.price.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import com.topicos.price.models.Policy;

public interface RepositoryPolicy extends ReactiveCrudRepository<Policy, Long> {
    Flux<Policy> findByNameContainingIgnoreCase(String name);
    Flux<Policy> findByDescriptionContainingIgnoreCase(String description);
    Flux<Policy> findByDiscount(double discount);
}
