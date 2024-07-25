package com.topicos.stock.repository;

import com.topicos.stock.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {
    //List<Stock> findByProductIgnoreCase(String product);
    Stock findByCodeIgnoreCase(String code);
    List<Stock> findByWarehouse_nameIgnoreCase(String warehouse_name);
    List<Stock> findByWarehouse_codeIgnoreCase(String warehouse_code);
}
