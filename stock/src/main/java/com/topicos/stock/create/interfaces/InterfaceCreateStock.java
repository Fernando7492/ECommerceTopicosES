package com.topicos.stock.create.interfaces;

import com.topicos.stock.models.Stock;

import java.util.List;
import java.util.Optional;

public interface InterfaceCreateStock {

    List<Stock> listStocksByWarehouse(String nome);

    Stock saveStock(Stock entity);

    List<Stock> listStocks();

    Optional<Stock> findByStockId(Long id);

    void deleteStock(Long id);

    void deleteStock(Stock entity);
}
