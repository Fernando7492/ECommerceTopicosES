package com.topicos.storage.create.interfaces;

import com.topicos.storage.models.Stock;

import java.util.List;
import java.util.Optional;

public interface InterfaceCreateStock {
    Stock saveStock(Stock entity);

    List<Stock> listStocks();

    List<Stock> listStocksByWarehouse(String name);

    Optional<Stock> findByStockId(Long id);

    Stock updateStock(Long id, Stock entity);

    void deleteStock(Long id);
}
