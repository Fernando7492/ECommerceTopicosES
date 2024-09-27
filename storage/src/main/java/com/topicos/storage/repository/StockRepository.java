package com.topicos.storage.repository;

import com.topicos.storage.models.Stock;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface StockRepository extends ReactiveCrudRepository<Stock, Long> {
    Mono<Stock> findByCodeIgnoreCase(String code);
}
