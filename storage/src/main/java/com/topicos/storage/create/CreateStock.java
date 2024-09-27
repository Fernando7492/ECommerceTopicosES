package com.topicos.storage.create;

import com.topicos.storage.create.exception.DuplicateRecordException;
import com.topicos.storage.create.exception.RecordNotFoundException;
import com.topicos.storage.create.interfaces.InterfaceCreateStock;
import com.topicos.storage.models.Stock;
import com.topicos.storage.repository.StockRepository;
import com.topicos.storage.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreateStock implements InterfaceCreateStock {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Override
    public Mono<Object> saveStock(Stock entity) {
        String code = entity.getCode();

        return stockRepository.findByCodeIgnoreCase(code)
                .flatMap(existingStock -> Mono.error(new DuplicateRecordException("Stock with code " + code + " already exists")))
                .switchIfEmpty(stockRepository.save(entity))
                .onErrorResume(Mono::error);
    }

    @Override
    public Flux<Stock> listStocks() {
        return stockRepository.findAll()
                .onErrorResume(Flux::error);
    }

    @Override
    public Mono<Stock> findByStockId(Long id) {
        return stockRepository.findById(id)
                .switchIfEmpty(Mono.error(new RecordNotFoundException("Stock with id " + id + " not found")))
                .onErrorResume(Mono::error);
    }

    @Override
    public Mono<Void> deleteStock(Long id) {
        return stockRepository.findById(id)
                .flatMap(stock -> stockRepository.deleteById(id))
                .switchIfEmpty(Mono.error(new RecordNotFoundException("Stock with id " + id + " not found")))
                .onErrorResume(Mono::error);
    }

    @Override
    public Mono<Stock> updateStock(Long id, Stock entity) {
        return stockRepository.findById(id)
                .switchIfEmpty(Mono.error(new RecordNotFoundException("Stock not found")))
                .flatMap(existingStock -> {
                    existingStock.setCode(entity.getCode());
                    existingStock.setQuantity(entity.getQuantity());
                    existingStock.setProductId(entity.getProductId());
                    existingStock.setWarehouseId(entity.getWarehouseId());
                    return stockRepository.save(existingStock);
                })
                .onErrorResume(Mono::error);
    }

    public Flux<Stock> createStocksForNewProduct(Long productId) {
        System.out.println("Creating stock for product: " + productId);
        return warehouseRepository.findAll()
                .flatMap(warehouse -> {
                    Stock stock = new Stock();
                    stock.setQuantity(0);
                    stock.setCode(warehouse.getCode() + "-" + productId);
                    stock.setProductId(productId);
                    stock.setWarehouseId(warehouse.getId());
                    return stockRepository.save(stock);
                });
    }
}
