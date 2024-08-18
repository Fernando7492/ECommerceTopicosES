package com.topicos.storage.repository;

import com.topicos.storage.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {
    Stock findByCodeIgnoreCase(String code);

    List<Stock> findByWarehouse_nameIgnoreCase(String warehouseName);

    List<Stock> findByWarehouse_codeIgnoreCase(String warehouseCode);
}
