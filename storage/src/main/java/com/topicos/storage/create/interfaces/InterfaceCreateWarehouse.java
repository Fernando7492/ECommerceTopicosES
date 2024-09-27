package com.topicos.storage.create.interfaces;

import com.topicos.storage.models.Warehouse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InterfaceCreateWarehouse {

    Mono<Object> saveWarehouse(Warehouse entity);

    Flux<Warehouse> listWarehouses();

    Mono<Warehouse> findByWarehouseId(Long id);

    Mono<Void> deleteWarehouse(Long id);

    Mono<Warehouse> updateWarehouse(Long id, Warehouse entity);
}
