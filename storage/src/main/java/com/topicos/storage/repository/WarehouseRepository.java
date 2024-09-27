package com.topicos.storage.repository;

import com.topicos.storage.models.Warehouse;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface WarehouseRepository extends ReactiveCrudRepository<Warehouse, Long> {
    Mono<Warehouse> findByCodeIgnoreCase(String code);
}
