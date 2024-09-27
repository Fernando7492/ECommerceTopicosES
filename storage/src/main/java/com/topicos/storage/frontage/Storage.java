package com.topicos.storage.frontage;

import com.topicos.storage.create.interfaces.InterfaceCreateStock;
import com.topicos.storage.create.interfaces.InterfaceCreateWarehouse;
import com.topicos.storage.models.Stock;
import com.topicos.storage.models.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class Storage {

    @Autowired
    private InterfaceCreateStock interfaceCreateStock;

    @Autowired
    private InterfaceCreateWarehouse interfaceCreateWarehouse;

    // ========================== STOCK ========================== //

    public Mono<Object> saveStock(Stock entity) {
        return interfaceCreateStock.saveStock(entity);
    }

    public Flux<Stock> listStocks() {
        return interfaceCreateStock.listStocks();
    }

    public Mono<Stock> findStock(Long id) {
        return interfaceCreateStock.findByStockId(id);
    }

    public Mono<Stock> updateStock(Long id, Stock entity) {
        return interfaceCreateStock.updateStock(id, entity);
    }

    public Mono<Void> deleteStock(Long id) {
        return interfaceCreateStock.deleteStock(id);
    }

    // ========================== WAREHOUSE ========================== //

    public Mono<Object> saveWarehouse(Warehouse entity) {
        return interfaceCreateWarehouse.saveWarehouse(entity);
    }

    public Flux<Warehouse> listWarehouses() {
        return interfaceCreateWarehouse.listWarehouses();
    }

    public Mono<Warehouse> findWarehouse(Long id) {
        return interfaceCreateWarehouse.findByWarehouseId(id);
    }

    public Mono<Warehouse> updateWarehouse(Long id, Warehouse entity) {
        return interfaceCreateWarehouse.updateWarehouse(id, entity);
    }

    public Mono<Void> deleteWarehouse(Long id) {
        return interfaceCreateWarehouse.deleteWarehouse(id);
    }
}
