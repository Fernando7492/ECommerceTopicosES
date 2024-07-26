package com.topicos.stock.create.interfaces;

import com.topicos.stock.models.Stock;

import java.util.List;
import java.util.Optional;

public interface InterfaceCreateStock {

    Stock saveStock(Stock entity);

    List<Stock> listStocks();

    List<Stock> listStocksByWarehouse(String nome);

    Optional<Stock> findByStockId(Long id);

    void deleteStock(Long id);
}
