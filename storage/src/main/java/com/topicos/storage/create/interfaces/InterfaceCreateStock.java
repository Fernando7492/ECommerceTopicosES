package com.topicos.storage.create.interfaces;

import com.topicos.storage.models.Stock;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

public interface InterfaceCreateStock {
    Mono<Object> saveStock(Stock entity);

    Flux<Stock> listStocks();

    Mono<Stock> findByStockId(Long id);

    Mono<Stock> updateStock(Long id, Stock entity);

    Mono<Void> deleteStock(Long id);
}
