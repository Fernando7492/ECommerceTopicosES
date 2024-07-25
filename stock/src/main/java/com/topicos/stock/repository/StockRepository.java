package com.topicos.stock.repository;

import com.topicos.stock.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
    Stock findByProductIgnoreCase(String product);
}
